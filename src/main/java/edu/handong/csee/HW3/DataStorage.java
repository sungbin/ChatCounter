package edu.handong.csee.HW3;

import java.util.ArrayList;
public class DataStorage {
	PatternCheck pt = new PatternCheck();
	ArrayList<String> kakao_id = new ArrayList<String>();
	ArrayList<Integer> count = null;
	
	
	
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
		
		if(count != null)
		{
			temp = count.get(gottenIndex);
			count.remove(gottenIndex);
		}
		else
		{
			count = new ArrayList<Integer>();
			temp = 0;
		}
		count.add(gottenIndex, temp+1);
		
		
		
	}
	

}
