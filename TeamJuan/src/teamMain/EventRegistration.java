package teamMain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves event registration information to a file.
 * 
 * @author Harman
 */

public class EventRegistration {

	private static String myFirst;
	private static String myLast;
	private static String myEvent;
	private static String myEmail;

	/**
	 * Constructor.
	 * 
	 * @param first
	 *            First name of user.
	 * @param last
	 *            Last name of user.
	 * @param event
	 *            The event user is registering for.
	 * @param email
	 *            User's email.
	 */
	public EventRegistration(String first, String last, String event, String email) {
		myFirst = first;
		myLast = last;
		myEvent = event;
		myEmail = email;
		writeFile();
	}

	/**
	 * Writes the registration information to the file.
	 */
	public static void writeFile() {
		String fileName = "eventReg.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.newLine();
			bufferedWriter.write(myFirst + "," + myLast + "," + myEmail + "," + myEvent);

			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}
}
