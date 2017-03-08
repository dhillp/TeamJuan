package teamMain;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JudgeSchedListScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    private JFrame myFrame;
    
    //comment
	public JudgeSchedListScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Login Window");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setSize(500, 500);
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
}
