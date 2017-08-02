package org.ktl.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CallPython {

	public List<String> runPython(String fileName) throws Exception{
		List<String> Footsize = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "python", "\"C:\\zzz\\foot_release.py\"", fileName);
		Process process = pb.start();
		BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );
		String str = null;
		// 표준출력 상태를 출력
		while( (str = stdOut.readLine()) != null ) {
	
			Footsize.add(str);
			
		}
		stdOut.close();
		return Footsize;
	}
	
}
