package bd2.Muber.model;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.google.gson.annotations.Expose;

public class Driver extends User {
	@Expose
	private License license;
	private Collection<Trip> trips;
	@Expose
	private double averageScore;
	
	public Driver(String username, String pass, Date creationDate, License license) {
		super(username, pass, creationDate);
		this.trips = new HashSet<Trip>();
		this.license = license;
	}

	public Driver() {
		super();
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public Collection<Trip> getTrips() {
		return trips;
	}

	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}
	
	public void addTrip(Trip trip){
		this.trips.add(trip);
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	
	public void updatesScore(){
		int score = 0;
		Iterator<Trip> tripIterator = this.getTrips().iterator();
		
		while(tripIterator.hasNext()){
			score = score + tripIterator.next().averageScore();
		}
		this.setAverageScore(score / this.getTrips().size());
	}
	
}