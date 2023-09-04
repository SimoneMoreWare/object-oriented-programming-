package it.ffss.train;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class Car {
	private String id;
	private int rows;
	private char lastSeat;
	private String klass;
	private int availableSeats;
	private Map<String,List<Integer>> seats=new TreeMap<>();
	public String getId() {
		return id;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public char getLastSeat() {
		return lastSeat;
	}
	public Map<String, List<Integer>> getSeats() {
		return seats;
	}
	public void setSeats(Map<String, List<Integer>> seats) {
		this.seats = seats;
	}
	public void setLastSeat(char lastSeat) {
		this.lastSeat = lastSeat;
	}
	public String getKlass() {
		return klass;
	}
	public void setKlass(String klass) {
		this.klass = klass;
	}
	public Car(String id, int rows, char lastSeat, String klass,int availableSeats) {
		super();
		this.id = id;
		this.rows = rows;
		this.lastSeat = lastSeat;
		this.klass = klass;
		this.availableSeats = availableSeats;
		int i,j;

		
		int m=(Character.getNumericValue(lastSeat)-Character.getNumericValue('A')+1);
		for(i=1;i<rows+1;i++)
		{
			char cc='A';
			for(j=0;j<m;j++)
			{
				String s=String.valueOf(i)+cc;
				seats.put(s, new ArrayList<>());
				cc++;
			}
				
		}
	}
	public void book(String seat,int begin,int end)
	{
		int j;
		List<Integer> s=seats.get(seat);
		for(j=begin;j<end;j++)
		{
			s.add(j);
		}
	}
}
