package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternSecond implements FindPattern{

	public boolean existPattern(String line) {
		Pattern p = Pattern.compile("(\\[)(\\S*)(\\])(\\s\\[.*(?:\\d{1}|\\d{2}):\\d{2}.*\\])");
		Matcher m = p.matcher(line);
		
		if(m.find())
			return true;

		return false;
	}

	public String return_kakao_name(String line) {
		Pattern p = Pattern.compile("(\\[)(\\S*)(\\])(\\s\\[.*(?:\\d{1}|\\d{2}):\\d{2}.*\\])");
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
