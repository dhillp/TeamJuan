package teamMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterScreen {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	private JTextField myFirstName;
	private JTextField myLastName;
	private JTextField myEmail;
	private JComboBox myCategoryBox;
	private JButton mySubmit;
	private JFrame myFrame;
	private Timer myTimer;
	
	
	public RegisterScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Create Account");
		myFrame.setSize(650, 250);
		myFrame.setResizable(false);
		createPanel();
		createTimer();
		//myTimer.start();
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
				SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent theEvent) {
				myTimer.stop();
			}
		});
		myFrame.setVisible(true);
	}
	
	private void createPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		myFirstName = new JTextField(20);
		myLastName = new JTextField(20);
		myEmail = new JTextField(40);
		myCategoryBox = new JComboBox();
		JLabel fName = new JLabel("Enter First Name: ");
		JLabel lName = new JLabel("Enter Last Name: ");
		JLabel email = new JLabel("Enter Email: ");
		JLabel category = new JLabel("Select Event/Category: ");
    	
    	constraint.gridx = 0;
    	constraint.gridy = 0;
    	constraint.gridwidth = 1;
    	panel.add(fName, constraint);
    	constraint.gridx = 1;
    	constraint.gridy = 0;
    	constraint.gridwidth = 2;
    	panel.add(myFirstName, constraint);
    	
    	constraint.gridx = 0;
    	constraint.gridy = 1;
    	constraint.gridwidth = 1;
    	panel.add(lName, constraint);
    	constraint.gridx = 1;
    	constraint.gridy = 1;
    	constraint.gridwidth = 2;
    	panel.add(myLastName, constraint);
    	
    	constraint.gridx = 0;
    	constraint.gridy = 2;
    	constraint.gridwidth = 1;
    	panel.add(email, constraint);
    	constraint.gridx = 1;
    	constraint.gridy = 2;
    	constraint.gridwidth = 2;
    	panel.add(myEmail, constraint);
    	
    	constraint.gridx = 0;
    	constraint.gridy = 3;
    	constraint.gridwidth = 1;
    	panel.add(category, constraint);
    	constraint.gridx = 1;
    	constraint.gridy = 3;
    	constraint.gridwidth = 2;
    	panel.add(myCategoryBox, constraint);
    	
    	createButtons();
    	JPanel panel2 = new JPanel();
    	panel2.add(mySubmit);
    	JPanel panel3 = new JPanel();
    	myFrame.getContentPane().add(panel3, BorderLayout.NORTH);
    	myFrame.getContentPane().add(panel, BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel2, BorderLayout.SOUTH);
	}
	
	private void createButtons() {
    	mySubmit = new JButton("Submit");
    	mySubmit.setEnabled(true);
    	mySubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent theEvent) {
    			new EventRegistration(getFirstName(), getLastName(), getEmail(), "");
				myTimer.stop();
				myFrame.dispose();
    		}
    	});
    }

	
	private void createTimer() {
		myTimer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent theEvent) {
	        	/* if (myFirstName.getText().length() > 0
	        			&& myLastName.getText().length() > 0
	        			&& myFirstName.getText().length() <= 20
	        			&& myLastName.getText().length() <= 20
	        			&& COMBO BOXES ARE SELECTED) {
	        		mySubmit.setEnabled(true);
	        	} else {
	        		mySubmit.setEnabled(false);
	        	} */
	        }
	    });
	}
    
    private String getFirstName() {
    	return myFirstName.getText().trim();
    }
    
    private String getLastName() {
    	return myLastName.getText().trim();
    }
    
    private String getEmail() {
    	return myEmail.getText().trim();
    }
    
    private String getEvent() {
    	return myCategoryBox.getSelectedItem().toString();
    }
}
