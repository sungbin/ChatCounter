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
		ArrayList<DataStorage> dslist = new ArrayList<DataStorage>();
		PatternFirst pf = new PatternFirst();
		PatternSecond ps = new PatternSecond();
		PatternThird pt = new PatternThird();
		
		Scanner inputStream = null;

		
		try {
			File f=new File(path+fname);
			//System.out.println(f.getAbsolutePath());
			inputStream = new Scanner(f,"UTF-8");
			DataStorage newds = null;
			
			while(inputStream.hasNextLine()) {
				String nextline = inputStream.nextLine();
				nextline = nextline.replaceAll(" \"", "\"");
				nextline = nextline.trim();
				
				if(nextline.contains("Java programing"))
				{
					System.out.println(nextline);
				}
				if(pf.existPattern(nextline))
				{
					newds = pf.makeData(nextline);
					dslist.add(newds);
				}
				else if(ps.existPattern(nextline))
				{
					newds = ps.makeData(nextline);
					dslist.add(newds);
				}
				else if(pt.existPattern(nextline))
				{
					nextline += "\"";
					newds = pf.makeData(nextline); //wiil be change
					dslist.add(newds);
					if(newds.getKakao_id().equals("남재창"))
					System.out.println("&& \"로 안끝남: "+nextline);
					
					/*String line = nextline;
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
					}*/
				}
			}
			inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dslist;
	}




}
