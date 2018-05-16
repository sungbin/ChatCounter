package edu.handong.csee.HW3;

import java.util.ArrayList;
public class DataStorage {
	PatternCheck pt = new PatternCheck();
	ArrayList<String> kakao_id = new ArrayList<String>();
	ArrayList<Integer> count = new ArrayList<Integer>();
	
	
	
	public ArrayList<String> getKakao_id() {
		return kakao_id;
	}



	public ArrayList<Integer> getCount() {
		return count;
	}



	/**
	 * 
	 */
	public void appoint(String line) {
		String name="";
		int gottenIndex = 0;
		int temp=0;
		
		name = pt.whatName(line);
		if (name == null)
			; //exception
		
		if(kakao_id.contains(name))
			gottenIndex = pt.getIndexByname(kakao_id, name);
		else
		{
			kakao_id.add(name);
			gottenIndex = pt.getIndexByname(kakao_id, name);
		}
		
		if(count.size()==0)
		{
			temp = 0;
			gottenIndex = 0;
		}
		else if(count.size()==gottenIndex)
		{
			temp = 0;
		}
		else
		{
			temp = count.get(gottenIndex);
			count.remove(gottenIndex);
		}
		count.add(gottenIndex, temp+1);
		
		
		
	}
	

}
