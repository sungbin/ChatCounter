package edu.handong.csee.HW3;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ChatCounter 
{
	private String path;
	private boolean verbose;
	private boolean help;
	private String outputName;
	private String numOfThreadStringType;
	

	
	/**
	 * @param main method
	 */
	public static void main(String[] args) {
		ChatCounter count = new ChatCounter();
		count.run(args,count);
	}
	
	/**
	 * support main method
	 */
	public void run(String[] args,ChatCounter cctt)
	{

		Options options = createOptions();
		FileOuter fo = new FileOuter();
		ArrayList<DataStorage> sumOfData = new ArrayList<DataStorage>();
		int temp;
		int numOfThread;
		int numOfFile;
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			try {
				String[] fileList = ChatCounter.FillInFileList(path+"/");
				
				if(!isStringDouble(numOfThreadStringType))
					throw new Exception("-c 옵션에는 숫자만 입력해야합니다.");
				numOfThread = Integer.parseInt(numOfThreadStringType);
				if(numOfThread>fileList.length)
					numOfThread = fileList.length;
				
				numOfFile = fileList.length; 
				String dividedFileList[][] =null;
				temp = numOfFile / numOfThread;
				dividedFileList = new String[numOfThread][temp+(numOfFile%numOfThread)];
				
				int y = 0;
				int x = 0;
				for(int i =0; i<numOfFile;i++)
				{
					dividedFileList[y][x] = fileList[i];
					x++;
					if((i+1)%temp==0&&(numOfFile-numOfFile%numOfThread)>(i+1))
					{
						y++;
					}
					if(x==temp&&(numOfFile-numOfFile%numOfThread)>(i+1))
						x=0;
				}
				
				ArrayList<FileLoader> flList = new ArrayList<FileLoader>();
				for(String[] filelist :dividedFileList)
				{
					if(fileList == null)
						continue;
					flList.add(new FileLoader(filelist, path));
				}
				
				for(FileLoader fl : flList)
				{
						fl.start();
						fl.join();
				}
					
				for(FileLoader fl : flList)
				{
					sumOfData.addAll(fl.getDslist());
				}
					
				sumOfData = fo.checkDuplicate(sumOfData);
					
				for(FileLoader fl : flList)
				{
					sumOfData.addAll(fl.getAddAffterDslist());
				}
					
				fo.makeOutFile(sumOfData,outputName);
				
			} catch(Exception e) { System.out.println(e.getMessage());}
			
		if(verbose) {
				System.out.println("******The program help parsing KaKaoTal Message");
				System.out.println("******You should appoint path of directory including data files(.csv or .txt)");
				System.out.println("******You should appoint path or file name too");
				System.out.println("****************************");
				System.out.println("******SeongBin Made it******");
				System.out.println("****************************");
				
			}
		}
	}

	private static String[] FillInFileList(String pathAddress) throws Exception {
		
		File file = new File(pathAddress);
		
		if(!file.exists())
			throw new Exception("존재하지 않는 디렉토리입니다."); //will be exception
		
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
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			numOfThreadStringType = cmd.getOptionValue("c");
			path = cmd.getOptionValue("i");
			outputName = cmd.getOptionValue("o");
			
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	private Options createOptions() {
		Options options = new Options();
		
		//add options Threads
		options.addOption(Option.builder("c").longOpt("thread")
				.desc("Set number of ` using calculate")
				.hasArg()
				.argName("number of thread")
				.required()
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("i").longOpt("path")
				.desc("Set a path of a directory to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		
		options.addOption(Option.builder("o").longOpt("name")
				.desc("Name your produced file")
				.hasArg()
				.argName("File name")
				.required()
				.build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());

		return options;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "KakaoTalk Message parser program";
		String footer ="\nPlease report issues at https://github.com/sungbin/ChatCounter";
		formatter.printHelp("ChatCounter", header, options, footer, true);
	}
	private static boolean isStringDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }

}
