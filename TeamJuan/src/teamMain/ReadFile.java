package teamMain;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Cynthia Tran

public class ReadFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		fileToArray(new File("Data2.txt"));
	}

	public static ArrayList<String> fileToArray(File file) throws FileNotFoundException {
		
		Scanner input = new Scanner(file);
		
		String[] temp = new String[30];
		ArrayList<String> list = new ArrayList<String>();
	
		while(input.hasNextLine()) {			
			temp = input.nextLine().trim().split(",");
			for (int i = 0; i < temp.length; i++) {
				list.add(temp[i]);
			}
		}
		
		System.out.println(list.toString());

		input.close();
		
		return list;

	}
	
	
	}
