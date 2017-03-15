package teamMain;

/**
 * Person class to hold each candidate's information.
 * @author Cynthia
 *
 */

public class Person {
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String personType;

	public Person(String firstName, String lastName, String email, String theType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		personType = theType;
	}

}
