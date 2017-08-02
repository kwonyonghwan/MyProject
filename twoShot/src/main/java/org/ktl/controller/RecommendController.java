package org.ktl.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.inject.Inject;

import org.ktl.domain.ConfidenceVO;
import org.ktl.domain.JsonData4D3;
import org.ktl.domain.MemberVO;
import org.ktl.domain.PersonalShoppingHistoryVO;
import org.ktl.domain.RecommendVO;
import org.ktl.dto.LoginDTO;
import org.ktl.service.AprioriService;
import org.ktl.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;


@Controller
@RequestMapping("/recommend/*")
public class RecommendController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	AprioriService service;
	
	@Inject
	MemberService mService;

	
	
	// 현재는 내 로컬 파일시스템에 있는 recommend.json파일에서 데이터를 읽어온다.
	// 근데 결국 서버에서 데이터를 그릴 데이터인 json파일을 가지고 있는게 맞으니까  원격 서버의 지정된 경로(json파일이 저장된 곳)에서 읽어와야하는 것이 맞지 않나..
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public ResponseEntity<String> readJSON(){
		//String filePath = "C:\\Users\\woojin\\Documents\\workspace-sts-3.7.3.RELEASE\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json";
		String filePath = "D:\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json"; 
		
		ResponseEntity<String> entity=null;
		try {
			File file=new File(filePath);
			InputStream in= new FileInputStream(file);
			
			Scanner sc = new Scanner(in);
			StringBuilder str=new StringBuilder();
			
			while(sc.hasNext()){
				str.append(sc.nextLine());
			}
			
			entity = new ResponseEntity<>(str.toString() , HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("여기");
		System.out.println(entity);
		
		return entity;
	}// readJSON()
	
	
	@RequestMapping(value="/detailRecommend", method=RequestMethod.GET)
	public void makeJSON(@RequestParam("pno") Integer pno) {
		// pno는 현재 보고있엇던 상세페이지의 상품 pno
		
		JsonData4D3 jsonData = new JsonData4D3();
		Gson gson = new Gson();
		String imagePath = "/resources/img_product/";
		//String filePath = "C:\\Users\\woojin\\Documents\\workspace-sts-3.7.3.RELEASE\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json";
		String filePath = "D:\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json"; 
		try {
			// pno 이용해서  bean만들고
			RecommendVO recVO = new RecommendVO();
			recVO.setPno(pno);
			
			// 현재 보고 있던 제품 정보 가져오고 나머지 정보는 setting 
			RecommendVO rVO = service.getRootdata(recVO);
			rVO.setProductthumimage(imagePath + rVO.getProductthumimage());
			rVO.setRootdata("true");
			rVO.setConfidence(0.6);
			rVO.setImagesize(4000);
			
			jsonData.setAllData(rVO.getPno(), rVO.getProductname(), rVO.getProductthumimage(), rVO.getConfidence(),
					rVO.getImagesize(), rVO.getRootdata());
			
			// 이와 관련된 추천 제품 가져오고
			ConfidenceVO cVO = new ConfidenceVO();
			cVO.setStartdata(pno.toString());
			
			List<RecommendVO> rList = service.executeD3(cVO);
			for (RecommendVO recommendVO : rList) {
				recommendVO.setProductthumimage(imagePath + recommendVO.getProductthumimage());
			}
			
			jsonData.setChildren(rList);
			String result = gson.toJson(jsonData);
			
			System.out.println("변환");
			System.out.println(result);
			
			// 파일(result) 저장.
			String fileName = filePath;
   
	    	// 이어쓰기
	    	//BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	    	// 덮어쓰기
	    	BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
	        
	        // 파일안에 문자열 쓰기
	        fw.write(result);
	        fw.flush();

	        // 객체 닫기
	        fw.close(); 
		} catch (Exception e) {
		
			e.printStackTrace();
		}// catch()

	}// detailRecommend()
	
	
	@RequestMapping(value="/personalRecommend", method=RequestMethod.GET)
	public String makePersonJSON(@RequestParam("memberid") String memberid) {
		// memberid는 현재 로그인한 고객의 id
			
		System.out.println("=========makePersonJSON 불림");
		
		
		JsonData4D3 jsonData = new JsonData4D3();
		Gson gson = new Gson();
		String imagePath = "/resources/img_product/";
		String userImagePath = "/resources/img_product/user.png";
		//String filePath = "C:\\Users\\woojin\\Documents\\workspace-sts-3.7.3.RELEASE\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json";
		String filePath = "D:\\spring-tool-suite-3.7.3.RELEASE-e4.5.2-win32-x86_64\\TwoShot\\src\\main\\webapp\\resources\\recommend\\recommend.json"; 
		
		// memberVO에 memberid를 세팅해준 다음, 이 memberVO를 getPersonalShoppingHistory로 날려서 내 구매이력 리스트를 가져온다.
		System.out.println("memberid : " + memberid);
		
		System.out.println("멤버 아이디 : " + memberid);
		
		
		MemberVO mVO = new MemberVO();
		mVO.setMemberid(memberid);
		
		try {
		
			if(memberid == null) {  //로그인 안된 상태라면
				return "/member/login";  // 이경로로 이동!
			
			}//if
			
			
			PersonalShoppingHistoryVO pshVO = service.getPersonalShoppingHistory(mVO);
			System.out.println("pshVO : " + pshVO);
			
			// 루트 노드 설정
			// 루트 이미지를 하나 고정으로 설정한다음 다른 값들도 고정으로 설정해줘. 그리고 json타입으로 바꿔.
			RecommendVO rVO = new RecommendVO();
			
			rVO.setPno(-1); // 나 자신의 pno는 -1값으로 의미론적으로 정해줬다.
			rVO.setProductname(memberid);
			rVO.setProductthumimage(userImagePath);
			rVO.setRootdata("true");
			rVO.setConfidence(0.6);
			rVO.setImagesize(4000);
						
			jsonData.setAllData(rVO.getPno(), rVO.getProductname(), rVO.getProductthumimage(), rVO.getConfidence(),
					rVO.getImagesize(), rVO.getRootdata());
						
			// 자식 노드 설정
			// 위에서 가져온 구매이력 리스트를 ,로 split한 후 이를 집합으로 바꿔(중복된 것들은 없애주기 위해서) 	
			String[] splitedShoppingHistory = pshVO.getShoppinghistory().split(",");
			
			Set<String> shSet = new HashSet<String>(Arrays.asList(splitedShoppingHistory)); 
	
			System.out.println("구매이력 리스트 : " + shSet.toString());
			
			List<RecommendVO> rList = new ArrayList<>();
			
			// 이 각각을 ConfidenceVO의 startdata로 세팅 한다음
			for (String shoppingHistoryItem : shSet) {
				
				ConfidenceVO cVO = new ConfidenceVO();
				cVO.setStartdata(shoppingHistoryItem );
				
				
				// 이 cVO를 service.executeD3(여기)에 넣어서 호출한다. 그러면 관련된 제품리스트를 받아오는데 이 제품 리스트를 전체 리스트에 add까지해준다.
				// 추천 제품리스트 A을 받아와
			
				List<RecommendVO> tempList = service.executeD3(cVO);
						
				for (RecommendVO tempVO : tempList) {
					System.out.println(tempVO);
					
					int idx = -1;
		
					//idx = rList.indexOf(tempVO);
					if(rList.size()!=0){
						for (RecommendVO tVO : rList) {
							System.out.println("들어옴?");
							
							if(tVO.getPno().equals(tempVO.getPno())){
								idx = rList.indexOf(tVO);
								System.out.println("if : " + idx);
								break;
							}
							else{
								idx = -1;
								System.out.println("else :"  + idx);
							}
						}// for()
					}
					System.out.println("idx : " + idx);
					
					// 중복 된게 없으면 그냥 rList에 추가
					if (idx == -1){					
						rList.add(tempVO);
					}else{// 중복 된게 있으면 confidence 비교
						
						if(rList.get(idx).getConfidence() >= tempVO.getConfidence()){
							System.out.println("do nothing");
						}else{
							rList.remove(idx);
							rList.add(tempVO);
						}// else
					}// else
				}// foreach()
			}// for()

			
			// rList 순회하면서 이미지 패스 바꿔주어야 한다.
			for (RecommendVO recommendVO : rList) {
				System.out.println("추천제품: " + recommendVO);
				recommendVO.setProductthumimage(imagePath + recommendVO.getProductthumimage());
			}// for()
			
			// 그러면 현재 나 자신의 구매이력리스트에 대한 제품리스트까지 모두 리스트로 가지고 있는 상태이다. 이 리스트를 json으로 바꿔주고 
			// 바뀐 json데이터를 가지는 파일을 써주면 끝.		
			jsonData.setChildren(rList);
			String result = gson.toJson(jsonData);
			
			System.out.println("JSON 변환");
			System.out.println(result);
			
			// 파일(result) 저장.
			String fileName = filePath;
			
			// 덮어쓰기
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
				        
			// 파일안에 문자열 쓰기
			fw.write(result);
			fw.flush();

			// 객체 닫기
			fw.close(); 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}// catch()
	
		return "/recommend/personalRecommend";
		
		
	}// makePersonJSON()
	
	
	
	
	

}// class
