package model;

public class Person {

	private String firstName;
	private String lastName;
	private String nationality;

	public Person() {
		super();
	}
	
	

	public Person(String firstName, String lastName, String nationality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", nationality=" + nationality + "]";
	}

}
