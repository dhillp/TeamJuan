package teamMain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.JTable;
import javax.swing.JTextField;

public final class LoginScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	
    private JButton myLoginButton;

    private JButton myUpcomingButton;
    
    private JButton myJSchedButton;
    
    private JButton myRegister;
    
    private JButton myCreateAccount;
    
//    private JTable myTable;
    
    private JTextField myEmail;
    
    private JPasswordField myPassword;
    
    private JFrame myFrame;
    
    public LoginScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Login Window");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanel();
		myFrame.pack();
		myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
		myFrame.setVisible(true);
    }
    
    private void createPanel() {
    	JPanel panel2 = new JPanel(new GridBagLayout());
    	JPanel panel3 = new JPanel();
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	myEmail = new JTextField(20);
    	myPassword = new JPasswordField(20);
    	JLabel user = new JLabel("Username: ");
    	JLabel pass = new JLabel("Password: ");
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 1;
    	panel2.add(user, c);
    	c.gridx = 1;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	panel2.add(myEmail, c);
    	c.gridx = 0;
    	c.gridy = 1;
    	c.gridwidth = 1;
    	panel2.add(pass, c);
    	c.gridx = 1;
    	c.gridy = 1;
    	c.gridwidth = 2;
    	panel2.add(myPassword, c);
    	createButtons();
    	JPanel panel = new JPanel();
    	panel3.add(myLoginButton);
//    	panel3.add(myCreateAccount);
    	panel3.add(myRegister);
//    	JPanel panel3 = new JPanel();
    	panel.add(myUpcomingButton);
    	panel.add(myJSchedButton);
    	JLabel upcomingEvents = new JLabel("Upcoming Events: ");
    	myFrame.getContentPane().add(upcomingEvents, BorderLayout.PAGE_START);
//    	JTable myTable = new JTable();
//    	JPanel p2 = new JPanel();
//    	readEvents r = new readEvents();
//		ArrayList<String> al = r.getdata();
//		for (int i = 0; i < al.size(); i++) {
//			p2.add(new JLabel(al.get(i) + "\n"));
//		}
//    	myFrame.getContentPane().add(p2, BorderLayout.CENTER);
//    	myFrame.getContentPane().add(new JScrollPane(myTable), BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel, BorderLayout.PAGE_START);
    	myFrame.getContentPane().add(panel2, BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel3, BorderLayout.PAGE_END);
    }
    private void createButtons() {
    	myLoginButton = new JButton("Login");
    	myLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
    	});
    	myCreateAccount = new JButton("Create Account");
    	myCreateAccount.addActionListener( new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			new CreateAccountScreen();
    		}
    	});
    	myUpcomingButton = new JButton("Upcoming Events");
    	myUpcomingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpcomingEventScreen();
			}
    		
    	});
    	myJSchedButton = new JButton("Judging Schedule");
    	myJSchedButton.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent theEvent) {
				try {
					new JudgeSchedListScreen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
    	});
    	myRegister = new JButton("Register");
    	myRegister.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent theEvent) {
				new RegisterScreen();
			}
    	});
    }

}

