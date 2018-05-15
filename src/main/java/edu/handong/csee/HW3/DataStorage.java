package edu.handong.csee.HW3;

import java.util.ArrayList;
public class DataStorage {
	PatternCheck pt = new PatternCheck();
	ArrayList<String> kakao_id = new ArrayList<String>();
	ArrayList<Integer> count = null;
	
	
	
	/**
	 * line을 받아드려 현재 DataStorage에 저장하는 역할을 한다.
	 */
	public void appoint(String line) {
		String name="";
		int num = 0;
		
		name = pt.whatName(line);
		if (name == null)
			; //exception
		
		if(kakao_id.contains(name))
			num = pt.getIndexByname(kakao_id, name);
		else
		{
			kakao_id.add(name);
			num = pt.getIndexByname(kakao_id, name);
		}
		
		if(count != null)
			count.remove(num);
		else
			count = new ArrayList<Integer>();
		count.add(num, count.get(num)+1);
		
		
		
	}
	

}
