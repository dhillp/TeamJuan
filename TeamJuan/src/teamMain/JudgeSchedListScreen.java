package teamMain;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JudgeSchedListScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    private JFrame myFrame;
    
    //comment
	public JudgeSchedListScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Judging Schedule");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setSize(500, 500);
		String[] columns = new String[] {
	            "Judge Name", "Event Location", "Category", "Date", "Time"
	        };
	    Object[][] data = new Object[][] {
	            {"Judge1", "Place1", "Category6", "1/1/18", "1:45 PM"}
	    	};
	    	

	    JTable table = new JTable(data, columns);
	    
	    myFrame.add(new JScrollPane(table));
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
}
