package teamMain;
import java.awt.EventQueue;
import java.io.File;

public class ProjectMain {

	/*
	 * CreateAccount doesn't check to see if the email is already
	 * in the system, so you can register the same email twice.
	 * Need to fix that.
	 */
	
	/*
	 * CHANGES:
	 * 1. I added a Person class to make the log-in process easier.
	 * 2. I modified the judgeScheduleScreen and called it "DisplayFile" 
	 * because I wanted to use it to show the Event file too.
	 * 3. I changed the code in the Login screen for the myLoginButton 
	 * to involve the Person class and to simplify the code. 
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
