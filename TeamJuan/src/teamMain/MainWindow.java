package teamMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Main application window that you see after logging in.
 * 
 * @author Pamaldeep
 * @author Cynthia
 */

public final class MainWindow {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    private JButton myUpcomingButton;
    
    private JButton myJSchedButton;
    
    private JButton myRegister;
    
    private JFrame myFrame;
    
    private Person myPerson;
    
    /**
     * Constructor for the GUI window.
     * 
     * @author Pamaldeep
     * @param thePerson the user that is logged in.
     */
    public MainWindow(Person thePerson) {
    	myPerson = thePerson;
		myFrame = new JFrame();
		myFrame.setTitle("JustBeWeave");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanel();
		myFrame.pack();
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
    
    /**
     * Creates panel to be added to the frame.
     * 
     * @author Pamaldeep
     */
    private void createPanel() {
    	createButtons();
    	JPanel panel = new JPanel();
    	panel.add(myRegister);
    	panel.add(myUpcomingButton);
    	panel.add(myJSchedButton);
    	JLabel upcomingEvents = new JLabel(" Welcome!");
    	myFrame.getContentPane().add(upcomingEvents, BorderLayout.PAGE_START);
    	myFrame.getContentPane().add(panel, BorderLayout.CENTER);
    }
    
    /**
     * Creates buttons that are added to the GUI.
     * 
     * @author Pamaldeep
     * @author Cynthia
     */
    private void createButtons() {
    	myUpcomingButton = new JButton("Upcoming Events");
    	myUpcomingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent x) {
				try {
					new ListScreen(new File("events.txt"), "Upcoming Events");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    		
    	});
    	myJSchedButton = new JButton("Judging Schedule");
    	myJSchedButton.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent theEvent) {
				try {
					new ListScreen(new File("judge.txt"), "Judging Schedule");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    	});
    	myRegister = new JButton("Register");
    	myRegister.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent theEvent) {
				new RegisterScreen(myPerson);
			}
    	});
    }

}

