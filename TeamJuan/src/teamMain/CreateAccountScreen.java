package teamMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateAccountScreen {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	private static JTextField myFirstName;
	private static JTextField myLastName;
	private static JTextField myEmail;
	private JLabel myEmailWarning;
	private JButton mySubmit;
	private JFrame myFrame;
	private Timer myTimer;
	
	public CreateAccountScreen() {
		myFrame = new JFrame();
		myFrame.setTitle("Create Account");
		myFrame.setSize(650, 250);
		myFrame.setResizable(false);
		createPanel();
		createTimer();
		myTimer.start();
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
		JLabel fName = new JLabel("Enter First Name: ");
		JLabel lName = new JLabel("Enter Last Name: ");
		JLabel email = new JLabel("Enter Email: ");
		myEmailWarning = new JLabel("");
    	myEmailWarning.setForeground(Color.RED);
    	myEmailWarning.setHorizontalAlignment(SwingConstants.CENTER);
    	
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
    	constraint.gridwidth = 3;
    	panel.add(myEmailWarning, constraint);
    	
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
    	mySubmit.setEnabled(false);
    	mySubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent theEvent) {
    			System.out.println("ok");
    			System.out.println(getFirstName());
    			System.out.println(getLastName());
    			System.out.println(getEmail());
    			//reading();
				writeFile();
    			
				myTimer.stop();
				myFrame.dispose();
    		}
    	});
    }
	
	private void createTimer() {
		myTimer = new Timer(100, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent theEvent) {
	        	if (emailTaken()) {
	        		myEmailWarning.setText("This Email is already registered.");
	        	} else {
	        		myEmailWarning.setText("");
	        	}
	        	if (!emailTaken()
	        			&& myFirstName.getText().length() > 0
	        			&& myLastName.getText().length() > 0
	        			&& myFirstName.getText().length() <= 20
	        			&& myLastName.getText().length() <= 20) {
	        
	        		mySubmit.setEnabled(true);
	        	} else {
	        		mySubmit.setEnabled(false);
	        	}
	       
	        }
	    });
	}
	
	private void reading()throws IOException{
			
			ArrayList<String> input = new ArrayList<>();
			String data;
			Scanner inFile = new Scanner(new File("judge.txt"));
			int i = 0;
			while(inFile.hasNextLine())
			{
			   data = inFile.nextLine();
			   input.add(i, data);
			   i++;
			   
			}

			ArrayList<String> test = null;
			test = input;
			String[] columns = new String[] {
					"First Name", "Last Name", "Time", "Date", "Category"
			}; 
			DefaultTableModel model = new DefaultTableModel(columns, 0);
			for(int i2 = 2; i < test.size(); i2++) {
				String temp = test.get(i2);
				String[] temp2 = temp.split(",");
				model.addRow(new Object[] {temp2[0], temp2[1], temp2[2], temp2[3], temp2[4]});

			}
			System.out.println(model.toString());
		
	}
			
	
	private static String myFirst;
	private static String myLast;
	private static String myEmail2;

	
	
	public static void writeFile(){
        String fileName = "Data2.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(getFirstName() + "," + getLastName() + "," + getEmail());
            bufferedWriter.newLine();
			bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }
    
    private static String getFirstName() {
    	return myFirstName.getText().toString();
    }
    
    private static String getLastName() {
    	return myLastName.getText().toString();
    }
    
    private static String getEmail() {
    	return myEmail.getText().toString();
    }
    
    private boolean emailTaken() {
    	//SEARCH FILE IF EMAIL IS ALREADY REGISTERED
    	return false;
    }
}
