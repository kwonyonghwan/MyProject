package org.ktl.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.ktl.util.CallPython;
import org.ktl.util.Doolleh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;


@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	
	private CallPython cp = new CallPython(); // 외부 프로그램인 파이썬코드를 실행시키기 위해서 만든 클래스
	private Doolleh doolleh = new Doolleh();//발의 둘레를 계산하기위해서 작성해 놓은 클래스
	private List<String> Footsize = new ArrayList<String>(); // 발 크기 정보를 담기위한 리스트 생성
	
	private String sex;
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadGetAjax() throws Exception{
		
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> DeleteAjax(@RequestBody String fileName){
	
		
		System.out.println("파일 이름 : " + fileName);
		boolean del1 = false;
		boolean del2 = false;
		boolean del3 = false;
		File file = new File("C:\\zzz\\"+fileName);
		del1 = file.delete();
		System.out.println("del1 성공 : "+del1);
		boolean isThumb = fileName.contains("_s_");
		if(isThumb == true){
			String modName = fileName.split("_s_")[0]+"_"+fileName.split("_s_")[1];
			System.out.println("원본 이름 : "+modName);
			File file2 = new File("C:\\zzz\\"+modName+"");
			del2 =file2.delete();
			System.out.println("del2 성공 : "+del2);
			
			String shapeName = modName.split("\\.")[0]+"_shape.png";
			System.out.println("발모양 파일명 : "+shapeName);
			File file3 = new File("C:\\zzz\\"+shapeName+"");
			del3 = file3.delete();
			System.out.println("del3 성공 : "+del3);
			
		}
		
	
		
		if(del1 == del2 == del3){
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}else{
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadPostAjax(MultipartFile file, Model model) throws Exception{
		logger.info(file.getOriginalFilename());
		logger.info(file.getContentType());
	
		UUID uid = UUID.randomUUID();
		
		List<String> extList = new ArrayList<String>();
		extList.add("image/jpeg");
		extList.add("image/jpg");
		extList.add("image/gif");
		extList.add("image/png");
		
		boolean checkImage = extList.contains(file.getContentType());
		
		String fileName = "C:\\zzz\\"+uid.toString() +"_"+file.getOriginalFilename();
		
		File target = new File(fileName);
		
		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(target));
		
		
		
		Footsize = cp.runPython(fileName);
		
		int footDoolleh = doolleh.calcDoolleh(Integer.parseInt(Footsize.get(1)), Integer.parseInt(Footsize.get(2)),sex);
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("filePath", Footsize.get(0));
		
		if(checkImage == true){
			
			
			
			BufferedImage srcImage = ImageIO.read(file.getInputStream());
			
			BufferedImage destImage = Scalr.resize(srcImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
			
			fileName = "C:\\zzz\\"+uid+"_s_"+file.getOriginalFilename();
			FileOutputStream fos = new FileOutputStream(fileName);
			 ImageIO.write(destImage, "jpg", fos);
			 fos.close();			
		}
		
		int num = fileName.lastIndexOf("\\")+1;
		
				
		jsonObj.put("fileName", fileName.substring(num));
		
		jsonObj.put("footLength", Footsize.get(1));
		jsonObj.put("footWidth", Footsize.get(2));
		jsonObj.put("footDoolleh", footDoolleh);
		
		
		String sendMsg = jsonObj.toString();
		
		return new ResponseEntity<String>(sendMsg,HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(value="/maleorfemale", method=RequestMethod.POST)
	public ResponseEntity<Boolean> maleOrFemale(HttpServletRequest req) throws Exception{
		BufferedReader in = new BufferedReader(req.getReader());
	    sex = in.readLine();
		System.out.println("Server : " + sex);
	    in.close();
	    if(sex == null){
	    	return new ResponseEntity<Boolean>(false,HttpStatus.OK);
	    }
	    	return new ResponseEntity<Boolean>(true,HttpStatus.OK); 
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		logger.info("fileName : " + fileName);
		if(fileName.contains("C:") == true){
			String[] tempString = fileName.split("\\");
			for (String string : tempString) {
				System.out.println(string);
			}
		}
		
		InputStream in = new FileInputStream("C:\\zzz\\"+fileName);
		
		HttpHeaders headers = new HttpHeaders();
		
		MediaType contentType = getMimeType(fileName);
		
		headers.setContentType(contentType);
		
		if(contentType == MediaType.APPLICATION_OCTET_STREAM){
		headers.add("Content-Disposition", "attachment;filename=\""+new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
		}
		
		
		ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.OK);
		
		
		in.close();
		return entity;
	}
	
	private MediaType getMimeType(String fileName){
		
		String ext = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
		
		Map<String,MediaType> map = new HashMap<String, MediaType>();
		
		map.put(".jpg", MediaType.IMAGE_JPEG);
		map.put(".png", MediaType.IMAGE_PNG);
		map.put(".jpeg", MediaType.IMAGE_JPEG);
		map.put(".gif", MediaType.IMAGE_GIF);
		
		MediaType result = map.get(ext);
		if(result == null){
			result= MediaType.APPLICATION_OCTET_STREAM;
		}
		
		return result;
	}
	@ResponseBody
	@RequestMapping("/filelist")
	public ResponseEntity<List<String>> getList(){
		
		File files = new File("C:\\zzz\\");
		
		List<String> newfiles = new ArrayList<String>();
		String[] names = files.list();
		
		
		
		for (String string : names) {
			boolean notFolder = string.contains(".");
			boolean isThumb = string.contains("_s_");
			
			if(notFolder == true ){
				if(getMimeType(string).equals(MediaType.APPLICATION_OCTET_STREAM)){
			
				newfiles.add(string);
				}else{
					if(isThumb == true){
				
						newfiles.add(string);
					}
				}
			}
			
		}
		
		
		return new ResponseEntity<List<String>>(newfiles,HttpStatus.CREATED);
	}
	public List<String> getFootSize(){
		System.out.println(Footsize.contains("252"));
		return Footsize;
	}
}
