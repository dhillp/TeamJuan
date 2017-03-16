package teamMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class' main function is to output an ArrayList given a file and
 * separates each item in the file into the array.
 * 
 * @author Harman
 */

public class ReadFile {

	public ReadFile() {
	}

	/**
	 * Reads a file and outputs an arraylist of file contents.
	 * 
	 * @param file File to be opened.
	 * @return ArrayList of file contents.
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> fileToArray(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		String[] temp = new String[30];
		ArrayList<String> list = new ArrayList<String>();

		while (input.hasNextLine()) {
			temp = input.nextLine().trim().split(",");
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
		}
		input.close();
		return list;
	}

}
