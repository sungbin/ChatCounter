package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternThird implements FindPattern {

	final static String pattern = "(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s)([0-2][0-9]):([0-5][0-9])(:[0-5][0-9]\\,\")((?:\\D|\\d)+)(\"\\,\")((?:\\D|\\d)+)";
	public String templine;
	
	@Override
	public boolean existPattern(String line) {
		if(line == null)
		return false; //exception
		templine = null;
	
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		
		if(m.find())
			return true;
	
		return false;
	}

	@Override
	public DataStorage makeData(String line) { //마지막 줄에 "를 읽으면 이걸 실행함.
		PatternFirst pf = new PatternFirst();
		return pf.makeData(templine+""+line);
		
	}
	
	public void savetemp(String line)
	{
		if(templine == null)
			templine = line;
		else
			templine+=line+"";
	}
}
