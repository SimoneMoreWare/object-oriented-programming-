package it.polito.med;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Schedule {
	
	private Doctor doctor;
	private String date;
	private String start;
	private String end;
	private int duration;
	
	public Schedule(Doctor doctor, String date, String start, String end, int duration) {
		super();
		this.doctor = doctor;
		this.date = date;
		this.start = start;
		this.end = end;
		this.duration = duration;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getSlot() {
		
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = LocalTime.parse(end);
		
		int difference = (int) Duration.between(startTime, endTime).toMinutes();
		
		return difference/duration;
		
	}
	
	public List<String> getSlots(){
		
		List<String> slots = new LinkedList<>();
		
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime;
		int i;
		String tmp = "";
		
		for(i=0;i<this.getSlot();i++) {
			endTime = startTime.plus(Duration.ofMinutes(duration));
			
			tmp = startTime.toString() + "-" + endTime.toString();
			
			slots.add(tmp);
			
			startTime = startTime.plus(Duration.ofMinutes(duration));
			
		}
		
		return slots;
		
	}

}
