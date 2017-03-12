package teamMain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EventRegistration {
	
//	private static String myFirst;
//	private static String myLast;
	private static String myEvent;
	private static String myEmail;

	
	public EventRegistration( String event
			,String email){
//		myFirst = first;
//		myLast = last;
		myEvent = event;
		myEmail = email;
		writeFile();
	}
	
	public static void writeFile(){
        String fileName = "Data.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName, true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(myEmail + "," + myEvent);
            bufferedWriter.newLine();
			bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }



	
	
	
	

}
