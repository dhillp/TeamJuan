package teamMain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class LoginScreen {
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	
    private JButton myLoginButton;

    private JButton myRegisterButton;
    
    private JTextField myUsername;
    
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
    	JPanel panel = new JPanel(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
    	myUsername = new JTextField(20);
    	myPassword = new JPasswordField(20);
    	JLabel user = new JLabel("Username: ");
    	JLabel pass = new JLabel("Password: ");
    	c.gridx = 0;
    	c.gridy = 0;
    	c.gridwidth = 1;
    	panel.add(user, c);
    	c.gridx = 1;
    	c.gridy = 0;
    	c.gridwidth = 2;
    	panel.add(myUsername, c);
    	c.gridx = 0;
    	c.gridy = 1;
    	c.gridwidth = 1;
    	panel.add(pass, c);
    	c.gridx = 1;
    	c.gridy = 1;
    	c.gridwidth = 2;
    	panel.add(myPassword, c);
    	createButtons();
    	JPanel panel2 = new JPanel();
    	panel2.add(myLoginButton);
    	panel2.add(myRegisterButton);
    	JPanel panel3 = new JPanel();
    	myFrame.getContentPane().add(panel3, BorderLayout.PAGE_START);
    	myFrame.getContentPane().add(panel, BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel2, BorderLayout.PAGE_END);
    }
    private void createButtons() {
    	myLoginButton = new JButton("Login");
    	myRegisterButton = new JButton("Register");
    	class myListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				
			}
    		
    	}
    	myRegisterButton.addActionListener(new myListener());
    	myLoginButton.addActionListener(new myListener());
    }

}

