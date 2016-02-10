package model;

public class Game {
	
	private GameInfo gameInfo;
	private Team home;
	private Team away;
	public Game() {
		super();
		
		
	}
	public GameInfo getGameInfo() {
		return gameInfo;
	}
	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getAway() {
		return away;
	}
	public void setAway(Team away) {
		this.away = away;
	}
	
	

}
