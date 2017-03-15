package teamMain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Harman
 *
 */

public class EventRegistration {
	
	private static String myFirst;
	private static String myLast;
	private static String myEvent;
	private static String myEmail;

	
	public EventRegistration( String first, String last, String event
			,String email) {
		myFirst = first;
		myLast = last;
		myEvent = event;
		myEmail = email;
		writeFile();
	}
	
	public static void writeFile() {
        String fileName = "eventReg.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(myFirst + "," + myLast + "," + myEmail + "," + myEvent);
            
			bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }
}
