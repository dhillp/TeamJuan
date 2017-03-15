package teamMain;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UpcomingEventScreen {

	private static final Toolkit KIT = Toolkit.getDefaultToolkit();

	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

	private JFrame myFrame;

	public UpcomingEventScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Upcoming Events");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setSize(500, 500);
		JTable table = new JTable();
		myFrame.add(new JScrollPane(table));
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
				SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
	}
}
