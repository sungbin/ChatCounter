package edu.handong.csee.HW3;

import java.util.ArrayList;

/**
 * are there Pattern in data?
 * return true or false
 */
public class PatternCheck {
	private PatternFirst pf = new PatternFirst();
	private patternSecond ps = new patternSecond();

	public boolean check(String string) {
		if(pf.existPattern(string)||ps.existPattern(string))
			return true;
		
		return false;
	}

	/**
	 * if data name is duplicated, get its index number.
	 */
	public int getIndexByname(ArrayList<String> arr,String pName)
    {
        for(String item : arr)
        {
            if(item.equals(pName))
                return arr.indexOf(item);
        }
        return -1;
    }

	/**
	 * if Pattern exist, return the name.
	 */
	public String whatName(String line) {
		if(pf.existPattern(line))
			return pf.return_kakao_name(line);
		if(ps.existPattern(line))
			return ps.return_kakao_name(line);
		return null;
	}

}
