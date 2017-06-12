package bd2.Muber.model;

import java.util.Collection;
import java.util.HashSet;

import com.google.gson.annotations.Expose;

public class Muber {
	
	private long id;
	@Expose
	private Collection<Driver> drivers;
	@Expose
	private Collection<Passenger> passengers;
	@Expose
	private Collection<Trip> trips;
	
	public Muber(){
		this.drivers = new HashSet<Driver>();
		this.passengers = new HashSet<Passenger>();
		this.trips = new HashSet<Trip>();
	}
	
	public Collection<Driver> getDrivers() {
		return drivers;
	}
	
	public void setDrivers(Collection<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public Collection<Passenger> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	public Collection<Trip> getTrips() {
		return trips;
	}
	
	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}
	
	public void addPassenger(Passenger passenger){
		this.passengers.add(passenger);
	}
	
	public void addDriver(Driver driver){
		this.drivers.add(driver);
	}
	
	public void addTrip(Trip trip){
		this.trips.add(trip);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
