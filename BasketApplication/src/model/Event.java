package model;



public class Event {

	private EventType keyword;
	private TeamType team;
	private int player;
	private boolean made;
	private int asist;
	private int fouled;
	private int blocked;
	public EventType getKeyword() {
		return keyword;
	}
	public void setKeyword(EventType keyword) {
		this.keyword = keyword;
	}
	public TeamType getTeam() {
		return team;
	}
	public void setTeam(TeamType team) {
		this.team = team;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public boolean isMade() {
		return made;
	}
	public void setMade(boolean made) {
		this.made = made;
	}
	public int getAsist() {
		return asist;
	}
	public void setAsist(int asist) {
		this.asist = asist;
	}
	public int getFouled() {
		return fouled;
	}
	public void setFouled(int fouled) {
		this.fouled = fouled;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	public Event() {
	}
	@Override
	public String toString() {
		return "Event [keyword=" + keyword + ", team=" + team + ", player=" + player + ", made=" + made + ", asist="
				+ asist + ", fouled=" + fouled + ", blocked=" + blocked + "]";
	}

	

}
