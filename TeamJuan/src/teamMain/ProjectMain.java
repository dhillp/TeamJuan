package teamMain;
import java.awt.EventQueue;

public class ProjectMain {

	/*
	 * WHAT STILL NEEDS TO BE DONE:
	 * 
	 * 1.	Display upcoming events in the UpcomingEventScreen
	 * 		like how the Judging schedule is displayed.
	 * 2.	Login needs to read first name, last name and email from the data file
	 * 		then pass it to MainWindow, which will pass it to RegisterScreen
	 * 		so that all the user has to select in the register screen
	 * 		is the event. Then first name, last name, email and event get passed
	 * 		into EventRegistration.
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
