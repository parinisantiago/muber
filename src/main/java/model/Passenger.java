package model;

import java.sql.Date;

public class Passenger extends User {

	private Float cash;
	private Trip[] trips;
    private Score[] scores;

	public Passenger(Float cash, Long id, String username, String pass, Date creationDate, Trip[] trips, Score[] scores) {
		this.pass = pass;
		this.id = id;
		this.username = username;
		this.creationDate = creationDate;
		this.cash = cash;
		this.trips = trips;
		this.scores = scores;
	}

	public Passenger() {
		super();
	}

	public Float getCash() {
		return cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}

	public Trip[] getTrips() {
   		return trips;
    }

    public void setTrips(Trip[] trips) {
   		this.trips = trips;
   	}

    public Score[] getScores() {
   		return scores;
   	}

    public void setScores(Score[] scores) {
   		this.scores = scores;
   	}
}
