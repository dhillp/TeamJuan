package teamMain;

/**
 * Person class to hold each candidate's information.
 * 
 * @author Cynthia
 */

public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private String personType;
	
	/**
	 * Constructor.
	 * 
	 * @param firstName First name of the user.
	 * @param lastName Last name of the user.
	 * @param email	User's email.
	 * @param theType The type of user (judge/attendee).
	 */
	public Person(String firstName, String lastName, String email, String theType) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		setPersonType(theType);
	}

	
	//Getter for firstName
	public String getFirstName() {
		return firstName;
	}

	//Setter for firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//Getter for lastName
	public String getLastName() {
		return lastName;
	}
	
	//Setter for firstName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//Getter for email
	public String getEmail() {
		return email;
	}

	//Setter for email
	public void setEmail(String email) {
		this.email = email;
	}

	//Getter for personType
	public String getPersonType() {
		return personType;
	}

	//Setter for personType
	public void setPersonType(String personType) {
		this.personType = personType;
	}

}
