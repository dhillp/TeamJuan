package teamMain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

/**
 * This class displays the judge.txt & events.txt files in the GUI.
 *
 * @author Cynthia
 * @author Tung
 */

public class DisplayFile {
	DisplayFile() {
	}

	/**
	 * Opens a file and returns the contents as an ArrayList.
	 * 
	 * @param file The file to be opened
	 * @return Contents of file as ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> OpenFile(File file) throws IOException {
		ArrayList<String> input = new ArrayList<>();
		String data;
		Scanner inFile = new Scanner(file);
		int i = 0;
		while (inFile.hasNextLine()) {
			data = inFile.nextLine();
			input.add(i, data);
			i++;

		}
		inFile.close();
		return input;
	}

	/**
	 * Returns the table model to be used to display the file contents.
	 * 
	 * @param file The file to be opened.
	 * @return table model of file contents.
	 */
	public DefaultTableModel getModel(File file) {
		ArrayList<String> test = null;
		boolean isJudge = (file.getName().equals("judge.txt")) ? true : false;

		try {
			test = OpenFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] judgeColumns = new String[] { "First Name", "Last Name", "Time", "Date", "Category" };
		String[] categoryColumns = new String[] { "Category", "Date" };

		DefaultTableModel model;
		int start = isJudge ? 2 : 0;

		if (isJudge) {
			model = new DefaultTableModel(judgeColumns, 0);
		} else {
			model = new DefaultTableModel(categoryColumns, 0);
		}
		for (int i = start; i < test.size(); i++) {
			String temp = test.get(i);
			String[] temp2 = temp.split(",");
			if (isJudge) {
				model.addRow(new Object[] { temp2[0], temp2[1], temp2[2], temp2[3], temp2[4] });
			} else {
				model.addRow(new Object[] { temp2[0], temp2[1] });
			}
		}
		return model;
	}
}
