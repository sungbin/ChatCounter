package edu.handong.csee.HW3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FileOuter {
	private HashMap<String, Integer> all_list = new HashMap<String, Integer>();

	/**
	 * move Data in ArrayList<DataStorage> to HashMap
	 * and print them.
	 */
	public void out(ArrayList<DataStorage> ds, String outputName) {

		int i;
		
		for(DataStorage data : ds)
		{
			ArrayList<String> id_list =  data.getKakao_id();
			ArrayList<Integer> count_list = data.getCount();
			int temp=0;
			i =0;
			
			for(String id : id_list)
			{
				temp = 0;
				if(all_list.containsKey(id))
				{
					temp = all_list.get(id);
				}
				all_list.put(id, temp+count_list.get(i));
				
				i++;
			}
		}
		// add makeResultFile(all_list)
		i=0;
		Iterator<String> key2 = all_list.keySet().iterator();
		while(key2.hasNext())
		{
			String key = key2.next();
			System.out.println(key + ", " + all_list.get(key));
		}
		
	}
	/**
	 * will be making result file method
	 */
	private static void makeResultFile(HashMap<String, Integer> all_list)
	{
		
	}

}
