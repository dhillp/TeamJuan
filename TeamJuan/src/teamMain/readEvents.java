package teamMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads Events from file for Register Screen
 * 
 * @author Cynthia
 */
public class readEvents {

	readEvents() {

	}
	
	/**
	 * Returns an ArrayList of all the events in the events file.
	 * 
	 * @return ArrayList of events from file
	 */
	public ArrayList<String> getdata() {

		ArrayList<String> eventsList = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader("events.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				eventsList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return eventsList;
	}
}
