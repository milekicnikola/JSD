package model;

public class Team {
	
	private String name;
	private Player[] players=new Player[11];
	private Person coach;
	public Team() {
		super();
	}
	
	
	
	public Team(String name, Player[] players, Person coach) {
		this.name = name;
		this.players = players;
		this.coach = coach;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public Person getCoach() {
		return coach;
	}
	public void setCoach(Person coach) {
		this.coach = coach;
	}
	
	
	
	

}
