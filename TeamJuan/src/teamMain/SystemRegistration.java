package teamMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SystemRegistration {
	
	private String myFirst;
	private String myLast;
	private String myId;
	private String myEmail;
	private String myCategory;
	
	public SystemRegistration(String first, String last, String id
			,String email, String category){
		myFirst = first;
		myLast = last;
		myId = id;
		myEmail = email;
		myCategory = category;
		
	}
    public static void main(String [] args) {
    	
    }
	
	private void writeFile(){
		String st = toString();

        String f = "Data.txt";
        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(f);
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                f + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + f + "'");                  

        }

    }
		
	
	
	public String toString(){
		String myString;
		myString = myId + "," + myFirst + "," + myLast + "," + myEmail + "," + myCategory;
		return myString;
	}
	
	
	

}
