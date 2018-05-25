package edu.handong.csee.HW3;

/**
 * there are two pattern
 *
 */
public interface FindPattern {
	/**
	 * Find regular expression
	 * if founded, return true, else return false
	 */
	public boolean existPattern(String string);
	/**
	 * Through regular Expression, return instance of DataStorage.
	 */
	public DataStorage makeData(String line);

}
