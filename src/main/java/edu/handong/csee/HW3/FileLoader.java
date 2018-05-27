package edu.handong.csee.HW3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileLoader {

	/**
	 * make file at path instances of DataStorage.
	 * and save them to ArrayList
	 * and return it.
	 */
	public ArrayList<DataStorage> makeDataList(String fname, String path) {
		ArrayList<DataStorage> dslist = new ArrayList<DataStorage>();
		PatternFirst pf = new PatternFirst();
		PatternSecond ps = new PatternSecond();
		PatternThird pt = new PatternThird();
		
		String nextline;

		
		try {
			File f=new File(path+"/"+fname);
			DataStorage newds = null;
			
			BufferedReader br = new BufferedReader(
                  new InputStreamReader(
                               new FileInputStream(f), "UTF-8"));
			while ((nextline = br.readLine()) != null)  {
				nextline = nextline.replaceAll(" \"", "\"");
				nextline = nextline.trim();
				
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
					newds = pt.makeData(nextline); 
					dslist.add(newds);
				}
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dslist;
	}




}
