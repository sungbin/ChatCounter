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
		String path = null;
		
		System.out.println("Path를 입력하세요.(아무것도 입력하지 않으면 C:\\Users\\tjdql\\Git\\ChatCounter\\Data)");
		path=in.nextLine();
		if(path.equals(""))
			path = "C:\\Users\\tjdql\\Git\\ChatCounter\\Data\\";

		System.out.println("Example: 자바-L18.csv, 자바-L7.txt, 자바-L6.csv");
		while(true)
		{
			System.out.println("Enter input name (exit: n)");
			
			inputName = in.nextLine();
			if(inputName.equals("n"))
				break;// will be exception
			//else if ... Exception
			
			ds.add(fl.load(inputName,path));
		}
		fo.out(ds,outputName);
		
	}

}
