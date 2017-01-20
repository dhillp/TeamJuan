import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class mainWindow {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();	
    private JButton myAboutButton;
    private JFrame myFrame;
    
    public mainWindow() {
		myFrame = new JFrame();
		myFrame.setTitle("Welcome Window");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanel();
		myFrame.setSize(350, 175);
		myFrame.setResizable(false);
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
    
    private void createPanel() {
    	createButtons();
    	JPanel panel1 = new JPanel();
    	panel1.add(myAboutButton);
    	myFrame.getContentPane().add(panel1, BorderLayout.NORTH);
    	myFrame.getContentPane().add(panel1, BorderLayout.SOUTH);
    }
    
    private void createButtons() {
    	myAboutButton = new JButton("About...");
    	myAboutButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent theEvent) {
				JOptionPane.showMessageDialog(null, "", 
						"About", JOptionPane.INFORMATION_MESSAGE);
    		}
    	});
    }
}