package edu.handong.csee.HW3;

import java.util.Scanner;
import java.util.ArrayList;

public class ChatCounter {
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ChatCounter count = new ChatCounter();
		count.run();
	}
	
	public void run()
	{
		ArrayList<DataStorage> ds = new ArrayList<DataStorage>();
		FileLoader fl = new FileLoader();
		FileOuter fo = new FileOuter();
		String Fname;
		
		while(true)
		{
			System.out.println("파일 이름을 입력하세요. (끝내기 n)");
			
			Fname = in.nextLine();
			if(Fname.equals("n"))
				break;// will be exception
			//else if ... Exception
			
			ds.add(fl.load(Fname));
		}
		
		fo.out(ds);
		
	}

}
