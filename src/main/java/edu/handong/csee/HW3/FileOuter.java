package edu.handong.csee.HW3;

import java.util.ArrayList;

public class FileOuter {

	public void out(ArrayList<DataStorage> ds, String outputName) {

		PatternCheck pt = new PatternCheck();
		ArrayList<String> all_id_list = new ArrayList<String>();
		ArrayList<Integer> all_count_list = null;
		int i;
		
		for(DataStorage data : ds)
		{
			ArrayList<String> id_list =  data.getKakao_id();
			ArrayList<Integer> count_list = data.getCount();
			int gottenIndex = 0;
			int temp=0;
			i =0;
			
			for(String id : id_list)
			{
				if(all_id_list.contains(id))
					gottenIndex = pt.getIndexByname(all_id_list, id);
				else
				{
					all_id_list.add(id);
					gottenIndex = pt.getIndexByname(all_id_list, id);
				}
				
				
				if(all_count_list != null)
				{
					temp = all_count_list.get(gottenIndex);
					all_count_list.remove(gottenIndex);
				}
				else
				{
					all_count_list = new ArrayList<Integer>();
				}
				all_count_list.add(gottenIndex, temp+count_list.get(i));
				
				i++;
			}
		}
		i=0;
		for(String id : all_id_list )
		{
			System.out.print(id + ", " + all_count_list.get(i));
			
			i++;
		}
		
	}

}
