package it.ffss.train;

public class Booking {
	private String ID;
	private String ssn;
	private String name;
	private String surname;
	private String begin;
	private String end;
	private boolean marked;
	private String car;
	public String getKlass() {
		return klass;
	}
	public void setKlass(String klass) {
		this.klass = klass;
	}
	private String klass;
	private String seat;
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
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Booking(String ID,String ssn, String name, String surname, String begin, String end, String car, String seat,String klass) {
		super();
		this.ID=ID;
		this.ssn = ssn;
		this.name = name;
		this.surname = surname;
		this.begin = begin;
		this.end = end;
		this.car = car;
		this.seat = seat;
		this.klass=klass;
		marked=false;
	}
	public void mark()
	{
		marked=true;
	}
}
