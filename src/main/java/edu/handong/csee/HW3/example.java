package edu.handong.csee.HW3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class example {

	final static String pattern = "(.+-.+-.+\\s)(\\d{2}):(\\d{2}):(\\d{2})\\,\"(.+)(\"\\,\")(.+)\"";
	
	//final static String pattern1 = "\\[(.*?)\\]\\s";
			//+ "\\[(d+):(d+)\\s(.+)]\\s(.*)";
	//final static String pattern2 = "\\[(.+)\\]\\s\\[(.+)\\s(d+):(d+)]\\s(.*)";
	
	public static void main(String[] args) {
		String input1 = "2018-03-30 01:03:12,\"최동현\",\"오늘까지인 과제 22시까지 맞나요? 늦은시간에 죄송합니다\"";
		String input2 = "[이상현] [오전 11:23] 넵!!";
		
		System.out.println(input1 +"\n" + input2);
		
		Pattern p1 = Pattern.compile(pattern);
		Matcher m1 = p1.matcher(input1);
		

		if(m1.matches())
		{
			
			System.out.println("find!!");
			
			System.out.println(m1.group(1));
			System.out.println(m1.group(2));
			System.out.println(m1.group(3));
			System.out.println("\""+m1.group(4)+"\"");
			System.out.println("\""+m1.group(5)+"\"");
			System.out.println(m1.group(6));
			System.out.println(m1.group(7));
		}
		
		System.out.println("*******");
		Pattern p2 = Pattern.compile(pattern);
		Matcher m2 = p2.matcher(input2);
		
		if(m2.matches())
		{
			System.out.println(m2.group(1));
			System.out.println(m2.group(2));
			System.out.println(m2.group(3));
			System.out.println("\""+m2.group(4)+"\"");
			System.out.println(m2.group(5));
			System.out.println(m2.group(6));
			System.out.println(m2.group(7));
		}
	}

}
