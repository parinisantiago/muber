package model;

import java.sql.Date;

public final class Trip {
	
	private String origin;
	private String destiny;
	private Float cost;
	private Integer maxPassengers;
	private Date dateTrip;
	private Passenger[] passengers;
	private Score[] score;
	
	
	public Trip() {
		super();
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	public Float getCost() {
		return cost;
	}
	
	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	public Integer getMaxPassengers() {
		return maxPassengers;
	}
	
	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	public Date getDateTrip() {
		return dateTrip;
	}
	
	public void setDateTrip(Date dateTrip) {
		this.dateTrip = dateTrip;
	}

	public Passenger[] getPassengers() {
		return passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}

	public Score[] getScore() {
		return score;
	}

	public void setScore(Score[] score) {
		this.score = score;
	}
}
