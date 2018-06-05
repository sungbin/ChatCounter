package edu.handong.csee.HW3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileLoader extends Thread {

	/**
	 * Constructor of FileLoader
	 * @param fnamelist
	 * @param path
	 */
	public FileLoader(String[] fnamelist, String path) {
		this.fnamelist = fnamelist;
		this.path = path;
	}

	private ArrayList<DataStorage> ddslist = new ArrayList<DataStorage>();
	private ArrayList<DataStorage> addAffterDslist = new ArrayList<DataStorage>();
	private PatternFirst pf = new PatternFirst();
	private PatternSecond ps = new PatternSecond();
	private PatternThird pt = new PatternThird();
	private String nextline;
	private String path;
	private String[] fnamelist;
	private FileOuter fo = new FileOuter();

	@Override
	/**
	 * Check duplicated each file.
	 * duplicated Data at same file are saved in 'addAffterDslist' variable.
	 * return data
	 */
	public void run() {
		for (String fname : fnamelist) {
			ArrayList<DataStorage> dslist = new ArrayList<DataStorage>();
			if (fname == null)
				continue;
			try {
				File f = new File(path + "/" + fname);
				DataStorage newds = null;

				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
				while ((nextline = br.readLine()) != null) {
					nextline = nextline.replaceAll(" \"", "\"");
					nextline = nextline.trim();

					if (pf.existPattern(nextline)) {
						newds = pf.makeData(nextline);
						dslist.add(newds);
					} else if (ps.existPattern(nextline)) {
						newds = ps.makeData(nextline);
						dslist.add(newds);
					} else if (pt.existPattern(nextline)) {
						newds = pt.makeData(nextline);
						dslist.add(newds);
					}
				}
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(fname + "을 읽는데 성공하였습니다.");

			dslist = fo.checkDuplicate(dslist);
			ddslist.addAll(dslist);
			addAffterDslist = fo.getIgnoredList();
		}
	}
	
	/**
	 * Getter of addAffterDslist
	 */
	public ArrayList<DataStorage> getAddAffterDslist() {
		return addAffterDslist;
	}

	/**
	 * Getter of ddslist
	 */
	public ArrayList<DataStorage> getDslist() {
		return ddslist;
	}

}
