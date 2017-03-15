package teamMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class RegisterScreen {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	private JComboBox<Object> myCategoryBox;
	private JButton mySubmit;
	private JFrame myFrame;
	private Person myPerson;
	
	/**
	 * @author Pamaldeep
	 * @param thePerson
	 */
	public RegisterScreen(Person thePerson) {
		myPerson = thePerson;
		myFrame = new JFrame();
		myFrame.setTitle("Register for Event");
		myFrame.setSize(650, 250);
		myFrame.setResizable(false);
		createPanel();
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
				SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
	}
	
	/**
	 * @author Pamaldeep and Harman
	 */
	private void createPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		myCategoryBox = new JComboBox<Object>();
		readEvents r = new readEvents();
		myCategoryBox.setModel(new DefaultComboBoxModel<Object>(r.getdata().toArray()));
		JLabel category = new JLabel("Select Event/Category: ");
    	
    	constraint.gridx = 0;
    	constraint.gridy = 0;
    	constraint.gridwidth = 1;
    	panel.add(category, constraint);
    	constraint.gridx = 1;
    	constraint.gridy = 0;
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
	
	/**
	 * @author Harman and Tung
	 */
	private void createButtons() {
    	mySubmit = new JButton("Submit");
    	mySubmit.setEnabled(true);
    	mySubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent theEvent) {
    			if(myPerson.personType.equals("Judge")) {
    				JOptionPane.showMessageDialog(myFrame, "Judges cannot register for event.");
    				
    			} else {
    				new EventRegistration(myPerson.firstName, myPerson.lastName, myPerson.email, getEvent());
    			}
				myFrame.dispose();
    		}
    	});
    }
     /**
      * @author Harman
      * @return
      */
    private String getEvent() {
    	return myCategoryBox.getSelectedItem().toString();
    }
}
