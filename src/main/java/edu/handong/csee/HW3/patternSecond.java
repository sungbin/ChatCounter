package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternSecond implements FindPattern{

	/**
	 * Find regular expression1
	 * if founded, return true, else return false
	 */
	public boolean existPattern(String line) {
		if(line == null)
			return false; //exception
		
		Pattern p = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[.*(?:\\d{1}|\\d{2}):\\d{2}.*\\])");
		Matcher m = p.matcher(line);
		
		if(m.find())
			return true;

		return false;
	}

	/**
	 * Through regular Expression, return name.
	 */
	public String return_kakao_name(String line) {
		
		Pattern p = Pattern.compile("(\\[)((?:\\D|\\d)+)(\\])(\\s\\[.*(?:\\d{1}|\\d{2}):\\d{2}.*\\])");
		Matcher m = p.matcher(line);
		
		if(m.find())
		{
			String gottenPattern = m.group();
			int startPattern = m.start(2);
			int endPattern = m.end(2);
			
			String name = gottenPattern.substring(startPattern, endPattern);
			return name;
		}
		else
		{
			//exception
		} 
		
		return null;
	}

}
