package edu.handong.csee.HW3;

import java.util.Scanner;

public class ChatCounter {
	Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ChatCounter count = new ChatCounter();
		count.run();
	}
	
	public void run()
	{
		DataStorage ds = new DataStorage();
		FileLoader fl = new FileLoader();
		FileOuter fo = new FileOuter();
		PatternCheck pc = new PatternCheck();
		
		
		System.out.println("파일 이름을 입력하세요.");
		FileLoader();
	}

}
