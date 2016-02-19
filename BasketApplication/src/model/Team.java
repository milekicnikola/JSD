package model;

import java.util.Arrays;

public class Team {
	
	private String name;
	private Player[] players=new Player[12];
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
	
	public void addPlayer(int index,Player p){
		players[index]=p;
	}



	@Override
	public String toString() {
		return "Team [name=" + name + ", players=" + Arrays.toString(players) + ", coach=" + coach + "]";
	}
	
	
	

}
