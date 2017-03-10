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
import java.util.ArrayList;

public class EventRegistration {
	
	private String myFirst;
	private String myLast;
	private String myId;
	private String myEmail;
	private String myCategory;
	private static ArrayList<String> list;

	
	public EventRegistration(String first, String last, String id
			,String email, String category){
		myFirst = first;
		myLast = last;
		myId = id;
		myEmail = email;
		myCategory = category;
		list = new ArrayList<String>();
		
	}
	
	private void writeFile(){
		String st = toString();



    }

	
	
	public String toString(){
		String myString;
		myString = myId + "," + myFirst + "," + myLast + "," + myEmail + "," + myCategory;
		return myString;
	}
	
	
	

}
