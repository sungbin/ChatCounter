package edu.handong.csee.HW3;

import java.util.Collections;
import java.util.Comparator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FileOuter {
	private HashMap<String, Integer> all_list = new HashMap<String, Integer>();

	/**
	 * move Data in ArrayList<DataStorage> to HashMap
	 * and print them.
	 */
	public void out(ArrayList<DataStorage> ds, String outputName) {
		
		ds = checkDuplicate(ds);
		Collections.sort(ds);
		
		for(DataStorage data : ds)
		{
			System.out.println(data);
		}
		for(DataStorage data : ds)
		{
			if(all_list.containsKey(data.getKakao_id()))
				all_list.put(data.getKakao_id(),all_list.get(data.getKakao_id())+1);
			else
				all_list.put(data.getKakao_id(),1);
		}

		Iterator it = FileOuter.sortByValue(all_list).iterator();
		
		while(it.hasNext())
		{
			String temp = (String) it.next();
			System.out.println(temp + ", " + all_list.get(temp));
		}
		
		
		
	}
	/**
	 * will be making result file method
	 */
	private static void makeResultFile(HashMap<String, Integer> all_list)
	{
		
	}
	
	private static ArrayList<DataStorage> checkDuplicate(ArrayList<DataStorage> ds)
	{
		HashSet<DataStorage> arr = new HashSet<DataStorage>(ds);
		
		ArrayList<DataStorage> arr2 = new ArrayList<DataStorage>(arr);
		
		return arr2;

	}


	public static List sortByValue(final Map map){ 
		List list = new ArrayList();
	list.addAll(map.keySet());
	Collections.sort(list,new Comparator(){ public int compare(Object o1,Object o2){ Object v1 = map.get(o1);
	Object v2 = map.get(o2); return ((Comparable) v1).compareTo(v2); } });
	Collections.reverse(list); // 주석시 오름차순 
	return list; 
	}
}