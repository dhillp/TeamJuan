package teamMain;
import java.awt.EventQueue;

/**
 * Driver for the application.
 * 
 * Authors for entire project:
 * @author Cynthia
 * @author Harman
 * @author Kevin
 * @author Pamaldeep
 * @author Tung
 */

public class ProjectMain {

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
