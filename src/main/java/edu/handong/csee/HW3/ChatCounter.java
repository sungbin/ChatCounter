package edu.handong.csee.HW3;

import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class ChatCounter {
	Scanner in = new Scanner(System.in);
	String path;
	boolean verbose;
	boolean help;
	String outputName;
	/**
	 * @param main method
	 */
	public static void main(String[] args) {
		ChatCounter count = new ChatCounter();
		count.run(args);
	}
	
	/**
	 * support main method
	 */
	public void run(String[] args)
	{
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			
			
			
			FileLoader fl = new FileLoader();
			FileOuter fo = new FileOuter();
			FileOuter fo2 = new FileOuter();
			ArrayList <DataStorage> Dslist = null;
			
			try {
				String[] fileList = ChatCounter.FillInFileList(path+"/");
				
				ArrayList<DataStorage> sumOfData = new ArrayList<DataStorage>();
				for(String filename : fileList)
				{
					Dslist = (fl.makeDataList(filename,path));
					System.out.println(filename+"을 읽는데 성공하였습니다.");
					fo2.checkDuplicate(Dslist);
					sumOfData.addAll(Dslist);
				}
				sumOfData = fo.checkDuplicate(sumOfData);
				sumOfData.addAll(fo2.getIgnoredList());
				
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

}
