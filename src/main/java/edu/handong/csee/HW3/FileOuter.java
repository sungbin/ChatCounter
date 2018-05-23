package edu.handong.csee.HW3;

import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileOuter {
	private TreeMap<String, Integer> all_list = new TreeMap<String, Integer>();

	/**
	 * move Data in ArrayList<DataStorage> to HashMap
	 * and print them.
	 */
	public void out(ArrayList<DataStorage> ds, String outputName) {
		
		for(DataStorage data : ds)
			if(data.getKakao_id().equals("Synergy"))
				System.out.println(data.getMessage());
		
		ds = checkDuplicate(ds);
		
		System.out.println("======================");
		for(DataStorage data : ds)
			if(data.getKakao_id().equals("Synergy"))
				System.out.println(data);
		
		for(DataStorage data : ds)
		{
			if(all_list.containsKey(data.getKakao_id()))
				all_list.put(data.getKakao_id(),all_list.get(data.getKakao_id())+1);
			else
				all_list.put(data.getKakao_id(),1);
		}

		makeResultFile(all_list, outputName);
		
		Iterator it2 = sortByValue(all_list).iterator();
		
		while(it2.hasNext())
		{
			String temp2 = (String) it2.next();
			System.out.println(temp2 + ", " + all_list.get(temp2));
		}
		System.out.println("===========================");
		
		
	}
	/**
	 * will be making result file method
	 */
	private static void makeResultFile(TreeMap<String, Integer> all_list, String outputName)
	{

		Iterator it = sortByValue(all_list).iterator();
		try {
			BufferedWriter pw = new BufferedWriter(new FileWriter(new File("Data/outputData/"+outputName)));

		while(it.hasNext())
		{
			String temp = (String) it.next();
			pw.write(temp + ", " + all_list.get(temp)+"\n");
		}
			pw.close();
		
		} catch(Exception e)
		{ System.out.println("파일을 읽는데 오류가 발생하였습니다.");}



		
		
	}
	
	private static ArrayList<DataStorage> checkDuplicate(ArrayList<DataStorage> ds)
	{
		DataStorage[] array = new DataStorage[ds.size()];
		DataStorage nullData = null;
		
		int size=0;

		for(DataStorage temp : ds){

		  array[size++] = temp;

		}
		
		for(int i=1;i<size;i++)
			for(int j=0;j<i;j++)
			{
				if(array[i].equals(array[j]))
				{
					if(array[i].getKakao_id().equals("Synergy"))
						System.out.println("***중복:"+array[i].toString()); //will be remove
					array[j] = nullData;
				}
			}
		
		ArrayList<DataStorage> newDs = new ArrayList<DataStorage>();
		
		for(DataStorage temp : array) {
			if(temp==null)
				continue;
			newDs.add(temp);
			}
		
		return newDs;

		
	}
	
	private static List sortByValue(final Map map) {

        List<String> list = new ArrayList();

        list.addAll(map.keySet());

         

        Collections.sort(list,new Comparator() {

             

            public int compare(Object o1,Object o2) {

                Object v1 = map.get(o1);

                Object v2 = map.get(o2);

                 

                return ((Comparable) v2).compareTo(v1);

            }

             

        });

        //Collections.reverse(list); // 주석시 오름차순

        return list;


    }
}