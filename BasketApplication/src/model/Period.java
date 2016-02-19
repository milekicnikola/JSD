package model;

import java.util.ArrayList;
import java.util.List;

public class Period {
	
	private List<Event> events=new ArrayList<>();

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event){
		this.events.add(event);
	}

	public Period() {
		
	}

	@Override
	public String toString() {
		return "Period [events=" + events + "]";
	}

	
	
	

}
