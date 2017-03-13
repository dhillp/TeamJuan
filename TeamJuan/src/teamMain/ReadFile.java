package teamMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Cynthia Tran
/*
 * This class' main function is to output an ArrayList
 * given a file and separates each item in the file
 * into the array using the String regex ','
 */

public class ReadFile {
	
	public ReadFile()  {}

	public ArrayList<String> fileToArray(File file) throws FileNotFoundException  {
		Scanner input = new Scanner(file);
		String[] temp = new String[30];
		ArrayList<String> list = new ArrayList<String>();

		while(input.hasNextLine()) {			 
			temp = input.nextLine().trim().split(",");
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
		}
		input.close();
		//System.out.println(list.toString());
		return list;
	}

}
