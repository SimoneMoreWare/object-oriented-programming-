package it.polito.med;

import java.util.LinkedList;
import java.util.List;

public class Doctor {
	
	private String id;
	private String name;
	private String surname;
	private String speciality;
	private List<Schedule> schedules = new LinkedList<>();
	private List<Appointment> appointments = new LinkedList<>();
	
	public Doctor(String id, String name, String surname, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public void newSchedule(Schedule schedule) {
		schedules.add(schedule);
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	public void newAppointment(Appointment appointment) {
		appointments.add(appointment);
	}
	
	public boolean isCompatibleDate(String date) {
		
		for(Schedule schedule: schedules) {
			if(schedule.getDate().equals(date)) return true;
		}
		
		return false;
		
	}
	
	public boolean isCompatibleSlot(String date, String slot) {
		
		for(Schedule schedule: schedules) {
			if(schedule.getDate().equals(date)) {
				List<String> slots = schedule.getSlots();
				if(slots.contains(slot)) return true;
			}
		}
		
		return false;
		
	}
	

}
