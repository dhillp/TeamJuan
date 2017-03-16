package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import teamMain.Person;
import teamMain.ReadFile;


/**
 * 
 * Because most of our classes consists of GUI components,
 * and our back-end isn't very complex, we were only able to 
 * test a few of the back-end functions.
 */

public class Test {
	
	/**
	 * Tests for Person class
	 *  @author Cynthia
	 *  @author Kevin
 	 *  @author Harman
	 */
	@org.junit.Test
	public void testPerson() {
		Person p = new Person("Beth", "Johnson", "bjohn@gmail.com", "judge");
		assertEquals(p.getFirstName(), "Beth");
		assertEquals(p.getLastName(), "Johnson");
		assertEquals(p.getEmail(), "bjohn@gmail.com");
		assertEquals(p.getPersonType(), "judge");
	}
	
	
	/**
	 * Tests for fileToArray() in the ReadFile class. 
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * 
	 * @author Cynthia
     * @author Palmadeep
     * @author Tung
	 */
	@org.junit.Test
	public void testReadFile() throws FileNotFoundException {
		ReadFile rf = new ReadFile();
		ArrayList<String> arr = rf.fileToArray(new File("test.txt"));
		assertEquals(arr.get(0), "team");
		assertEquals(arr.get(1), "juan");
		assertEquals(arr.get(2), "is");
		assertEquals(arr.get(3), "the");
		assertEquals(arr.get(4), "best");
		assertEquals(arr.get(5), "team");
	}

}
