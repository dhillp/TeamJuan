package teamMain;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateAccountScreen {
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
	private static JTextField myFirstName;
	private static JTextField myLastName;
	private static JTextField myEmail;
	
	private JRadioButton judgeButton = new JRadioButton("Judge");
	private JRadioButton attendeeButton = new JRadioButton("Attendee");
	private JLabel myEmailWarning;
	private JButton mySubmit;
	private JFrame myFrame;
	private Timer myTimer;
	private ArrayList<Person> myCandidates;
	private static ButtonGroup myRadioButtonGroup = new ButtonGroup();
//	private static Person p;
	
	public CreateAccountScreen(ArrayList<Person> myCandidates) {
		this.myCandidates = myCandidates;
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
		
		attendeeButton.setSelected(true);
		
		myRadioButtonGroup.add(attendeeButton);
		myRadioButtonGroup.add(judgeButton);
		
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
    	panel3.add(attendeeButton);
    	panel3.add(judgeButton);
    	myFrame.getContentPane().add(panel3, BorderLayout.NORTH);
    	myFrame.getContentPane().add(panel, BorderLayout.CENTER);
    	myFrame.getContentPane().add(panel2, BorderLayout.SOUTH);
	}
	
	private void createButtons() {
    	mySubmit = new JButton("Submit");
    	mySubmit.setEnabled(false);
    	mySubmit.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent theEvent) {
    			myCandidates.add(new Person(getFirstName(), getLastName(), getEmail(), getRadioButtonSelected()));
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
	        	try {
					if (emailTaken(myEmail.getText())) {
						myEmailWarning.setText("This Email is already registered.");
						myEmailWarning.setVisible(true);
						mySubmit.setEnabled(false);
						
					} else {
						myEmailWarning.setText("");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					if (!emailTaken(myEmail.getText())
							&& myFirstName.getText().length() > 0
							&& myLastName.getText().length() > 0
							&& myFirstName.getText().length() <= 20
							&& myLastName.getText().length() <= 20) {
      
						mySubmit.setEnabled(true);
					} else {
						mySubmit.setEnabled(false);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			//System.out.println(model.toString());
		
	}
			
	
	/**
	 * Saves account registration information to database(text file).
	 */
	public static void writeFile(){
        String fileName = "sysReg.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(getFirstName() + "," + getLastName() + "," + getEmail() + "," + getRadioButtonSelected());
            
			bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }
    
	private static String getRadioButtonSelected() {
		String buttonText = "";
		Enumeration elements = myRadioButtonGroup.getElements();
	    while (elements.hasMoreElements()) {
	      AbstractButton button = (AbstractButton)elements.nextElement();
	      if (button.isSelected()) {
	        buttonText = button.getText();
	      }
	    }
	    return buttonText;
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
    
    /**
     * Checks if email is already registered.
     * @param theEmail
     * @return
     * @throws FileNotFoundException
     */
    private boolean emailTaken(String theEmail) throws FileNotFoundException {
    	//SEARCH FILE IF EMAIL IS ALREADY REGISTERED
    	ArrayList<String> input = new ArrayList<>();
		String data;
		Scanner inFile = new Scanner(new File("sysReg.txt"));
		int i = 0;
		while(inFile.hasNextLine())
		{
		   data = inFile.nextLine();
		   input.add(i, data);
		   i++;
		   
		}

		ArrayList<String> emailList = new ArrayList<>();
		
		for(int j = 0; j < input.size(); j++) {
			String temp = input.get(j);
			String[] temp2 = temp.split(",");
			emailList.add(temp2[2]);
			
		}
		
		if(emailList.contains(theEmail)) {
			return true;
		}
		inFile.close();
    	return false;
    }
}
