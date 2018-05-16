package edu.handong.csee.HW3;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternFirst implements FindPattern{
	
	public boolean existPattern(String line) {
		if(line == null)
			return false; //exception
		
		Pattern p = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\,\\s)(\\S*)(\\,\")");
		Matcher m = p.matcher(line);
		
		if(m.find())
			return true;

		return false;
	}

	public String return_kakao_name(String line) {

		Pattern p = Pattern.compile("(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\\,\\s)(\\S*)(\\,\")");
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
