package edu.handong.csee.HW3;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoader {

	public DataStorage load(String fname) {
		DataStorage ds = new DataStorage();
		BufferedReader br = null;
		PatternCheck pc = new PatternCheck();
		
		//fname에서 한 줄을 받아드린다.
		//그 한 줄을 pattern 검사 한다.
		//검사한 값을 ds에 넣는다.
		//반복하다가 ds를 return 한다.
		
		try {
			br = new BufferedReader(new FileReader(fname));
			String line = null;
			while(pc.check(line = br.readLine())) {
				ds.appoint(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ds;
	}



}
