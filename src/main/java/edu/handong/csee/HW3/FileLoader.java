package edu.handong.csee.HW3;

import java.io.File;
import java.util.Scanner;

public class FileLoader {

	public DataStorage load(String fname) {
		DataStorage ds = new DataStorage();
		PatternCheck pc = new PatternCheck();

		Scanner inputStream = null;

		
		try {
			
			inputStream = new Scanner(new File("data/"+fname),"UTF-8");
			String line = null;
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				System.out.println(line);
				if(pc.check(line))
				{
					ds.appoint(line);
				}
			}
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}



}
