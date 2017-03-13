package teamMain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class LoginScreen {

	private static final Toolkit KIT = Toolkit.getDefaultToolkit();	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();	
	private JFrame myFrame;
	private JButton myLoginButton;
	private JButton myCreateAccount;
	private JTextField myEmail;
	private ArrayList<Person> myCandidates = new ArrayList<>();

	public LoginScreen() {
		readUserInfo();
		myFrame = new JFrame();
		myFrame.setTitle("Login Window");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		myFrame.pack();
		myFrame.setResizable(false);
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
				SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
	}

	private void createPanels() {
		myEmail = new JTextField(30);
		JLabel email = new JLabel("Enter Email: ");
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel.add(email, c);
		c.gridx = 1;
		c.gridy = 0; 
		c.gridwidth = 2;
		panel.add(myEmail, c);
		JPanel panel2 = new JPanel();
		myLoginButton = new JButton("Login");
		
		myLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = myEmail.getText();
				if (!email.equals("")) {
					for (int i = 0; i < myCandidates.size(); i++) {
						if (email.equals(myCandidates.get(i).email)) {
							new MainWindow(myCandidates.get(i));
							myFrame.dispose();
							return;
						} 
					}
					JOptionPane.showMessageDialog(myFrame, "Email not registered or it was entered incorrectly.");
				} 

			}
		});
		panel2.add(myLoginButton);
		myCreateAccount = new JButton("Create Account");
		myCreateAccount.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateAccountScreen(myCandidates);
				
			}
		});
		panel2.add(myCreateAccount);
		myFrame.getContentPane().add(panel, BorderLayout.CENTER);
		myFrame.getContentPane().add(panel2, BorderLayout.PAGE_END);
	}

	/**
	 * Cynthia --
	 * Read's user data and separates the information into a Person object. 
	 * A list stores each candidate's info in a person object. 
	 * This is to make the code more modular and also decouples the code.
	 * 
	 *  Edited: took out initialization of instance variable.
	 */
	public void readUserInfo() {
		//myCandidates = new ArrayList<Person>();
		try {
			ArrayList<String> usrData = new ReadFile().fileToArray(new File("sysReg.txt"));
			for (int i = 0; i < usrData.size(); i += 4) {
				Person p = new Person(usrData.get(i), usrData.get(i+1), usrData.get(i+2), usrData.get(i+3));
				myCandidates.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
