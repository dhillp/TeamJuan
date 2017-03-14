package teamMain;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    private JFrame myFrame;
    
    
    //comment
	public ListScreen(File file, String name) throws IOException {
		
		myFrame = new JFrame();
		myFrame.setTitle(name);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setSize(500, 500);
		
		DisplayFile r = new DisplayFile();
		
		DefaultTableModel model = r.getModel(file);
	    JTable table = new JTable();

	    table.setModel(model);

	    myFrame.add(new JScrollPane(table));
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
	
	
}