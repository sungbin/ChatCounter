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
	private ArrayList<DataStorage> ignoredList = new ArrayList<DataStorage>();

	/**
	 * move Data in ArrayList<DataStorage> to HashMap
	 * and make result file.
	 */
	public void makeOutFile(ArrayList<DataStorage> ds, String outputName) {
		for(DataStorage data : ds)
		{
			if(all_list.containsKey(data.getKakao_id()))
				all_list.put(data.getKakao_id(),all_list.get(data.getKakao_id())+1);
			else
				all_list.put(data.getKakao_id(),1);
		}
		Iterator it = sortByValue(all_list).iterator();
		try {
			BufferedWriter pw = new BufferedWriter(new FileWriter(new File(outputName)));

		while(it.hasNext())
		{
			String temp = (String) it.next();
			pw.write(temp + ", " + all_list.get(temp)+"\n");
		}
			pw.close();
			System.out.println(outputName+"파일을 성공적으로 만들었습니다.");
		} catch(Exception e)
		{ System.out.println("파일을 출력하는데 오류가 발생하였습니다.");}
		
	}
	/**
	 * in ArrayList <DataStorage>, find duplicated data.
	 * and remove them, return the ArrayList.
	 * store removed data to member variable ArrayList ignoredList
	 */
	
	public ArrayList<DataStorage> checkDuplicate(ArrayList<DataStorage> ds)
	{
		DataStorage[] array = new DataStorage[ds.size()];
		DataStorage nullData = null;
		int size=0;
		for(DataStorage temp : ds){
		  array[size++] = temp;
		}
		for(int i=size-2;i>=0;i--)
			for(int j=i+1;j<size-1;j++)
			{
				if(array[i].equals(array[j]))
				{
					this.ignoredList.add(array[j]);
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
	
	public ArrayList<DataStorage> getIgnoredList() {
		return ignoredList;
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
        return list;
    }
}