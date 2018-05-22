package edu.handong.csee.HW3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {

	/**
	 * call in Data.
	 * and Output result as ArrayList <DataStorage> type.
	 */
	public ArrayList<DataStorage> load(String fname, String path) {
		ArrayList<DataStorage> ds = new ArrayList<DataStorage>();
		PatternCheck pc = new PatternCheck();
		PatternFirst pf = new PatternFirst();
		patternSecond ps = new patternSecond();
		
		Scanner inputStream = null;

		
		try {
			File f=new File(path+fname);
			System.out.println(f.getAbsolutePath());
			inputStream = new Scanner(f,"UTF-8");
			String line = null;
			while(inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				if(pc.check(line))
				{
					if(pf.existPattern(line))
						ds.add(pf.makeData(line));
					else if(ps.existPattern(line))
						ds.add(ps.makeData(line));
				}
			}
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}

	//String fileList[] = path.list(new FilenameFilter() {




}
