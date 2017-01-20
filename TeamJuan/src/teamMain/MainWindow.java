package teamMain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class MainWindow {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();	
    private JButton myAboutButton;
    private JFrame myFrame;
    
    public MainWindow() {
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
<<<<<<< HEAD:TeamJuan/src/Pamal/mainWindow.java
				JOptionPane.showMessageDialog(null, "We Are Team Juan!\n-Pamaldeep Dhillon - \n-Kevin Nguyen - I like to ride bikes. \n-Cynthia Tran - I have a dog.", 
=======
				JOptionPane.showMessageDialog(null, "We Are Team Juan!"
						+ "\n-Pamaldeep Dhillon - "
						+ "\n-Tung Kong - "
						+ "\n-Kevin Nguyen - I like to ride bikes."
						+ "\n-Harmandeep Singh - "
						+ "\n-Cynthia Tran - ", 
>>>>>>> ca93f6cd431f61ef7fe17cef04257c4f6d8a8f8b:TeamJuan/src/teamMain/MainWindow.java
						"About", JOptionPane.INFORMATION_MESSAGE);
    		}
    	});
    }
}