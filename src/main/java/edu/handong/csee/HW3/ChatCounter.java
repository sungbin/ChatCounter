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

		System.out.println("Example: 자바-L18.csv, 자바-L7.txt, 자바-L6.csv");
		while(true)
		{
			System.out.println("Enter input name (exit: n)");
			
			inputName = in.nextLine();
			if(inputName.equals("n"))
				break;// will be exception
			//else if ... Exception
			
			ds.add(fl.load(inputName));
		}
		fo.out(ds,outputName);
		
	}

}
