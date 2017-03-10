package teamMain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class readJudge {
	readJudge(){
		
	}
	
	public ArrayList<String> OpenFile() throws IOException {
		ArrayList<String> input = new ArrayList<>();
		String data;
		Scanner inFile = new Scanner(new File("judge.txt"));
		int i = 0;
		while(inFile.hasNextLine())
		{
		   data = inFile.nextLine();
		   input.add(i, data);
		   i++;
		   
		}
		return input;
	}
	
	public DefaultTableModel getModel(){
		ArrayList<String> test = null;
		try {
			test = OpenFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] columns = new String[] {
				"First Name", "Last Name", "Time", "Date", "Category"
		}; 
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		for(int i = 2; i < test.size(); i++) {
			String temp = test.get(i);
			String[] temp2 = temp.split(",");
			model.addRow(new Object[] {temp2[0], temp2[1], temp2[2], temp2[3], temp2[4]});

		}
		return model;
}
}
