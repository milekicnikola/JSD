package model;



public class Player extends Person {

	private int number;
	private String position;

	public Player() {
		super();
	}

	
	
	
	public Player(String firstName, String lastName, String nationality, int number, String position) {
		super(firstName, lastName, nationality);
		this.number = number;
		this.position = position;
	}




	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}




	@Override
	public String toString() {
		return "[#" + number + ", " + position + ", " + getFirstName()
				+ " " + getLastName() + ", " + getNationality()+"]";
	}
	
	
	
	

}
