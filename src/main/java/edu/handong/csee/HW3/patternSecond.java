package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternSecond implements FindPattern{

	final static String pattern = "\\[(.*?)\\]\\s\\[((.*)?\\s)?(\\d+):(\\d+)(?:\\s([A-Z]{2})|.?)\\]\\s(.*?)";
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


		
		DataStorage data = new DataStorage();
		String name = null, hours = null, minutes = null, message = null;
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		
		String amORpm = null;
		if(m.matches())
		{
		if(String.valueOf(m.group(6)).equals("PM")||String.valueOf(m.group(6)).equals("AM"))
		{
			
			
			name = m.group(1);
			hours = m.group(4);
			minutes = m.group(5);
			message = m.group(7);
			
			
			amORpm=m.group(6); //AM, PM
			
		}
		
		if(String.valueOf(m.group(3)).equals("오후")||String.valueOf(m.group(3)).equals("오전"))
		{

			name = m.group(1);
			hours = m.group(4);
			minutes = m.group(5);
			message = m.group(7);
			
			amORpm=m.group(2); //
			
			
		}
		
		data.setKakao_id(name);
		data.setHours(hours);
		data.setMinutes(minutes);
		data.setMessage(message);
	
		
		int currentHours = Integer.parseInt(data.getHours());
	
		if(amORpm.equals("오후")||amORpm.equals("PM"))
			currentHours += 12;
		if (currentHours>24)
			currentHours -= 24;
		data.setHours(String.valueOf(currentHours));
		}
		return data;
	}
	}