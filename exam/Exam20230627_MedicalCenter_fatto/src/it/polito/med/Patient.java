package it.polito.med;

import java.util.LinkedList;
import java.util.List;

public class Patient {
	
	private String ssn;
	private String name;
	private String surname;
	private List<Appointment> appointments = new LinkedList<>();
	
	public Patient(String ssn, String name, String surname) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.surname = surname;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
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
	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	public void newAppointment(Appointment appointment) {
		appointments.add(appointment);
	}
	

}
