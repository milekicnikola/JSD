package model;

import java.util.Arrays;

public class Game {

	private GameInfo gameInfo;
	private Team home;
	private Team away;
	private Period[] periods = new Period[5];

	private static Game instance = null;

	protected Game() {
	      // Exists only to defeat instantiation.
	   }

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
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

	public Period[] getPeriods() {
		return periods;
	}

	public void setPeriods(Period[] periods) {
		this.periods = periods;
	}

	@Override
	public String toString() {
		return "Game [gameInfo=" + gameInfo + ", home=" + home + ", away=" + away + ", periods="
				+ Arrays.toString(periods) + "]";
	}

}
