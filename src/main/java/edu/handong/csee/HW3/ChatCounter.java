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
		String inputName, outputName = null;
		
		while(true)
		{
			System.out.println("Enter input name (exit: n)");
			
			inputName = in.nextLine();
			if(inputName.equals("n"))
				break;// will be exception
			//else if ... Exception
			
			ds.add(fl.load(inputName)); //-> ds 에 데이터 저장.
		}
		System.out.println();
		fo.out(ds,outputName); //-> ds에 있는 데이타를 종합해서 outputname으로 파일을 만듬.
		
	}

}
