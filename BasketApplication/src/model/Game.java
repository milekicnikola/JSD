package model;


public class Game {

	private GameInfo gameInfo;
	private Team home;
	private Team away;
	
	
	private Period period1;
	private Period period2;
	private Period period3;
	private Period period4;
	private Period overTime;
	
	
	

	private static Game instance = null;

	protected Game() {
		period1=new Period();
		period2=new Period();
		period3=new Period();
		period4=new Period();
		overTime=new Period();
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

	public Period getPeriod1() {
		return period1;
	}

	public void setPeriod1(Period period1) {
		this.period1 = period1;
	}

	public Period getPeriod2() {
		return period2;
	}

	public void setPeriod2(Period period2) {
		this.period2 = period2;
	}

	public Period getPeriod3() {
		return period3;
	}

	public void setPeriod3(Period period3) {
		this.period3 = period3;
	}

	public Period getPeriod4() {
		return period4;
	}

	public void setPeriod4(Period period4) {
		this.period4 = period4;
	}

	public Period getOverTime() {
		return overTime;
	}

	public void setOverTime(Period overTime) {
		this.overTime = overTime;
	}

	@Override
	public String toString() {
		return "Game [gameInfo=" + gameInfo + ", home=" + home + ", away=" + away + ", period1=" + period1
				+ ", period2=" + period2 + ", period3=" + period3 + ", period4=" + period4 + ", overTime=" + overTime
				+ "]";
	}

	


}
