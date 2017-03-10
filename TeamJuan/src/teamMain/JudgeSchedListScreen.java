package teamMain;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JudgeSchedListScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    private JFrame myFrame;
    
    private String file = "judge.txt";
    
    //comment
	public JudgeSchedListScreen() throws IOException {
		
		myFrame = new JFrame();
		myFrame.setTitle("Judging Schedule");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setSize(500, 500);
		
		ArrayList<String> test = OpenFile();
		
		String[] columns = new String[] {
				"First Name", "Last Name", "Time", "Date", "Category"
		}; 
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		
		for(int i = 2; i < test.size(); i++) {
			String temp = test.get(i);
			
			String[] temp2 = temp.split(",");
			
			model.addRow(new Object[] {temp2[0], temp2[1], temp2[2], temp2[3], temp2[4]});
		}
	    
	    JTable table = new JTable();
	    table.setModel(model);

	    
	    myFrame.add(new JScrollPane(table));
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
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
}