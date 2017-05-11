package bd2.Muber.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import com.google.gson.annotations.Expose;

public class Passenger extends User {
	@Expose
	private double cash;
	private Collection<Trip> trips;
	@Expose
    private Collection<Score> scores;

	public Passenger() {
		super();
	}
	
	public Passenger(String username, String pass, Date creationDate, double cash) {
		super(username, pass, creationDate);
		this.cash = cash;
		this.trips = new HashSet<Trip>();
		this.scores = new HashSet<Score>();
	}


	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public Collection<Trip> getTrips() {
   		return trips;
    }

    public void setTrips(Collection<Trip> trips) {
   		this.trips = trips;
   	}

    public Collection<Score> getScores() {
   		return scores;
   	}

    public void setScores(Collection<Score> scores) {
   		this.scores = scores;
   	}
    
    public void addTrip(Trip trip){
    	this.trips.add(trip);
    }
    
    public void addScore(Score score){
    	this.scores.add(score);
    }

    public void addCash(double cash){
    	this.cash = this.cash + cash;
    }
    
	public void pay(double cost) {
		this.cash = this.cash - cost;
	}
}