package edu.handong.csee.HW3;

import java.io.File;
import java.util.Scanner;

public class FileLoader {

	/**
	 * call in Data.
	 * and Output result as ArrayList <DataStorage> type.
	 */
	public DataStorage load(String fname, String path) {
		DataStorage ds = new DataStorage();
		PatternCheck pc = new PatternCheck();

		Scanner inputStream = null;

		
		try {
			File f=new File(path+fname);
			System.out.println(f.getAbsolutePath());
			inputStream = new Scanner(f,"UTF-8");
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
