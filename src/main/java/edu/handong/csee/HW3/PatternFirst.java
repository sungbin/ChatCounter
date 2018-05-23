package edu.handong.csee.HW3;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternFirst implements FindPattern{
	
	final static String pattern = "(.+-.+-.+\\s)(\\d{2}):(\\d{2}):(\\d{2})\\,\"(.+)(\"\\,\")(.+)\"";
	
	
	/**
	 * Find regular expression1
	 * if founded, return true, else return false
	 */
	public boolean existPattern(String line) {
		if(line == null)
			return false; //exception
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		
		if(m.find())
			return true;

		return false;
	}
	
	/**
	 * Through regular Expression, return name.
	 */
	public DataStorage makeData(String line) {
		
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(line);
			
			DataStorage data = null;
			if(m.matches())
			{
				data = new DataStorage();
				data.setHours(String.valueOf(Integer.parseInt(m.group(2))));
				data.setKakao_id(m.group(5));
				data.setMessage(m.group(7));
				data.setMinutes(String.valueOf(Integer.parseInt(m.group(3))));
			}
			
		return data;
	}

}
