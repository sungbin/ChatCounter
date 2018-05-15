package edu.handong.csee.HW3;

import java.util.regex.Pattern;

public class PatternFirst implements FindPattern{
	private String pattern = "^20[0-9]{2}-[0-1][0-9]-[0-3][1-9]\s[0-2][0-9]:[0-5][0-9]:[0-5][0-9]\,\s\S*\s\,$";

	public boolean existPattern(String string) {
		if(pattern.matches(string))
			return true;

		return false;
	}

	public String return_kakao_name(String line) {
		// TODO Auto-generated method stub
		return null;
	}

}
