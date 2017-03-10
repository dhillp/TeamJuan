package teamMain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EventRegistration {
	
	private String myFirst;
	private String myLast;
	private String myEvent;
	private String myEmail;
	private String myCategory;

	
	public EventRegistration(String first, String last, String event
			,String email, String category){
		myFirst = first;
		myLast = last;
		myEvent = event;
		myEmail = email;
		myCategory = category;
		writeFile();
	}
	
	private void writeFile(){
		String st = toString();
        String fileName = "Data.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(toString());
            bufferedWriter.newLine();
			bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }

	public String toString(){
		String myString;
		myString = myEvent + "," + myFirst + "," + myLast + "," + myEmail + "," + myCategory;
		return myString;
	}
	
	
	

}
