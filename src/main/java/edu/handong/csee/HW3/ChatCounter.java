package edu.handong.csee.HW3;

import java.util.Scanner;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ChatCounter {
	Scanner in = new Scanner(System.in);

	/**
	 * @param main method
	 */
	public static void main(String[] args) {
		ChatCounter count = new ChatCounter();
		count.run();
	}
	
	/**
	 * support main method
	 */
	public void run()
	{
		FileLoader fl = new FileLoader();
		FileOuter fo = new FileOuter();
		String outputName = null;
		String path = null;
		
		System.out.println("Path를 입력하세요.(아무것도 입력하지 않으면 /Users/imseongbin/Documents/Java/ChatCounter/Data/)");
		path=in.nextLine();
		if(path.equals(""))
			path = "/Users/imseongbin/Documents/Java/ChatCounter/Data/";
		
		
		String[] fileList = ChatCounter.FillInFileList(path);
		
		ArrayList<DataStorage> sumOfData = new ArrayList<DataStorage>();
		
		for(String filename : fileList)
		{
			
			sumOfData.addAll((fl.load(filename,path)));
		}
		fo.out(sumOfData,outputName);
		
	}

	private static String[] FillInFileList(String pathAddress) {
		
		File file = new File(pathAddress);
		
		if(!file.exists())
			System.out.println("존재하지 않는 디렉토리입니다."); //will be exception
		
	        String[] fileList = file.list(new FilenameFilter()
	        {
	            @Override
	            public boolean accept(File dir, String name) 
	            {
	            	if(name.endsWith(".txt"))
	            		return true;
	            	else if(name.endsWith(".csv"))
	                	return true;
	            	else
	            		return false;
	            }
	        });
	        System.out.println("path 하위 디렉토리에서 읽어드릴 수 있는 파일의 개수: "+fileList.length + "개 입니다.");
		return fileList;
	}


}
