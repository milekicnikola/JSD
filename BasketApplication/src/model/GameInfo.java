package model;

public class GameInfo {
	
	private String city;
	private String arena;
	private String date;
	private String time;
	private int attendance;
	private Person crewChief;
	private Person referee;
	private Person umpire;
	
	public GameInfo() {
		super();
	}
	
	

	public GameInfo(String city, String arena, String date, String time, int attendance, Person crewChief,
			Person referee, Person umpire) {
		super();
		this.city = city;
		this.arena = arena;
		this.date = date;
		this.time = time;
		this.attendance = attendance;
		this.crewChief = crewChief;
		this.referee = referee;
		this.umpire = umpire;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArena() {
		return arena;
	}

	public void setArena(String arena) {
		this.arena = arena;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public Person getCrewChief() {
		return crewChief;
	}

	public void setCrewChief(Person crewChief) {
		this.crewChief = crewChief;
	}

	public Person getReferee() {
		return referee;
	}

	public void setReferee(Person referee) {
		this.referee = referee;
	}

	public Person getUmpire() {
		return umpire;
	}

	public void setUmpire(Person umpire) {
		this.umpire = umpire;
	}

	
	
	

}
