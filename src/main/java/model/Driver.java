package model;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;


public class Driver extends User {
	
	private License license;
	private Collection<Trip> trips;
	
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
	
}
