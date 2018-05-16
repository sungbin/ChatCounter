package edu.handong.csee.HW3;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoader {

	public DataStorage load(String fname) {
		DataStorage ds = new DataStorage();
		BufferedReader br = null;
		PatternCheck pc = new PatternCheck();
		
		
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
