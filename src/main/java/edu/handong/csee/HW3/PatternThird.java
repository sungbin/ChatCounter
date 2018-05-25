package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternThird implements FindPattern {

	final static String pattern = "(20[0-1][0-9]-[0-1][0-9]-[0-3][1-9]\\s)([0-2][0-9]):([0-5][0-9])(:[0-5][0-9]\\,\")((?:\\D|\\d)+)(\"\\,\")((?:\\D|\\d)+)";
	/**
	 * Find regular expression2
	 * if founded, return true, else return false
	 */
	@Override
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
	 * Through regular Expression3, return instance of DataStorage.
	 */
	@Override
	public DataStorage makeData(String line) {
		PatternFirst pf = new PatternFirst();
		return pf.makeData(line+"\"");
	}
}
