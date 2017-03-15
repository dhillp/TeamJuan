package teamMain;
import java.awt.EventQueue;

/**
 * Driver for the application.
 * 
 * @author Cynthia
 * @author Harman
 * @author Kevin
 * @author Pamaldeep
 * @author Tung
 */

public class ProjectMain {

	/* LAST THING(?):
	 * CreateAccount doesn't check to see if the email is already
	 * in the system, so you can register the same email twice.
	 * Need to fix that by writing code for the emailTaken() function.
	 * 
	 * I think that's that last thing and then we just have to clean
	 * up the code, add comments and all that.
	 */
	
	/*
	 * CHANGES:
	 * 1. I added a Person class to make the log-in process easier.
	 * 2. I modified the judgeScheduleScreen and called it "DisplayFile" 
	 * because I wanted to use it to show the Event file too.
	 * 3. I changed the code in the Login screen for the myLoginButton 
	 * to involve the Person class and to simplify the code. 
	 */
	/**
	 * Runs the application.
	 * 
	 * @param theArgs Used for command-line arguments.
	 */
	public static void main(String[] theArgs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginScreen();
			}
		});
	}

}
