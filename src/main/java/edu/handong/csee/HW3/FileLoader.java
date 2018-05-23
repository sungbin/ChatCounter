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
		PatternThird pt = new PatternThird();
		
		Scanner inputStream = null;

		
		try {
			File f=new File(path+fname);
			//System.out.println(f.getAbsolutePath());
			inputStream = new Scanner(f,"UTF-8");
			DataStorage newds = null;
			
			while(inputStream.hasNextLine()) {
				String nextline = inputStream.nextLine();
				if(nextline.contains("Synergy"))
					System.out.println(nextline);
				if(pf.existPattern(nextline))
				{
					newds = pf.makeData(nextline);
					ds.add(newds);
				}
				else if(ps.existPattern(nextline))
				{
					newds = ps.makeData(nextline);
					ds.add(newds);
				}
				else if(pt.existPattern(nextline))
				{
					String line = nextline;
					pt.savetemp(line);
					while(inputStream.hasNextLine())
					{
						line = inputStream.nextLine();
						if(line.endsWith("\""))
						{
							newds = pt.makeData(line);
							ds.add(newds);
							break;
						}
						else
							pt.savetemp(line);
					}
				}
				
			}
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}




}
