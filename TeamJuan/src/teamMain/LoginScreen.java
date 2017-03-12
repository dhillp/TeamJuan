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
    
    public LoginScreen() {
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
    			try {
					if(ReadFile(myEmail.getText().toString())){
					new RegisterScreen();
					}else{
						JOptionPane.showMessageDialog(myFrame, "Email not registered");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			//IF EMAIL IN TEXT FILE THEN SIGN IN AND OPEN NEW
    			//MAIN WINDOW, THEN DISPOSE THIS WINDOW
    		}

			private boolean ReadFile(String string) throws FileNotFoundException {
				Scanner input = new Scanner(new File("Data2.txt"));
				
				String[] temp = new String[30];
				ArrayList<String> list = new ArrayList<String>();
			
				while(input.hasNextLine()) {			
					temp = input.nextLine().trim().split(",");
					for (int i = 0; i < temp.length; i++) {
						list.add(temp[i]);
						//System.out.print(temp[2]);
					}
				}
				
				boolean isitthere = false;
				System.out.println(string.toString());
				for(int k = 2; k<list.size();k=k+2){
					System.out.println(list.get(k));
					if(string.equals(list.get(k).toString())){
						System.out.println("true");
						isitthere = true;
					}
				}
				System.out.println(isitthere);
				if(isitthere){
					isitthere = false;
					return true;
				}
				
				System.out.println(list.toString());
			
				input.close();
				
				return false;
			}
    	});
    	panel2.add(myLoginButton);
    	myCreateAccount = new JButton("Create Account");
    	myCreateAccount.addActionListener( new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			new CreateAccountScreen();
    		}
    	});
    	panel2.add(myCreateAccount);
    	myFrame.getContentPane().add(panel, BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel2, BorderLayout.PAGE_END);
    }
}
