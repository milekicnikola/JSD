package model;

enum Position {
	PG, SG, SF, PF, C, G, F
}

public class Player extends Person {

	private int number;
	private Position position;

	public Player() {
		super();
	}

	
	
	
	public Player(String firstName, String lastName, String nationality, int number, Position position) {
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	

}
