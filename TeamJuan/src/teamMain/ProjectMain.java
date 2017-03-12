package teamMain;
import java.awt.EventQueue;

public class ProjectMain {

	/*
	 * WHAT STILL NEEDS TO BE DONE:
	 * 
	 * 1.	Need back-end for logging in which checks if the email being
	 * 		used to login is in the file or not then logs them in if it is
	 * 		(otherwise a pop-up will appear saying account doesn't exist)
	 * 2.	EventRegistration.java: Change it to where it accepts only email
	 * 		and event as inputs and then looks up the corresponding info for
	 * 		the user in the system registration data file and then stores that
	 * 		in the data file
	 * 3.	Set up the GUI to work with the back-end.
	 */
	
	public static void main(String[] theArgs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				new MainWindow();
				new LoginScreen();
			}
		});
	}

}
