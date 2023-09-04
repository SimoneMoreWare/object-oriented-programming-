package it.polito.med;

import it.polito.med.MedManager.Status;

public class Appointment {
	
	private Patient patient;
	private Doctor doctor;
	private String date;
	private String start;
	private String end;
	private String id;
	private Status status;
	
	public Appointment(Patient patient, Doctor doctor, String date, String slot, String id) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		String slotTime[] = slot.split("-");
		this.start = slotTime[0];
		this.end = slotTime[1];
		this.id = id;
		this.status = Status.BOOK;
	}
	


	public void setStatus(Status status) {
		this.status = status;
	}


	public void setAccepted(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}


	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return start + "=" + patient.getSsn();
	}
	
	
	

}
