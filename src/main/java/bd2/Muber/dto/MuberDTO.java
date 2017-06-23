package bd2.Muber.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.google.gson.annotations.Expose;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Trip;


public class MuberDTO {
	@Expose
	private Collection<DriverDTO> drivers;
	@Expose
	private Collection<PassengerDTO> passengers;
	@Expose
	private Collection<TripDTO> trips;
	
	public MuberDTO(Muber muber){
		this.drivers = new HashSet<DriverDTO>();
		this.passengers = new HashSet<PassengerDTO>();
		this.trips = new HashSet<TripDTO>();

		Iterator<Driver> driverI = muber.getDrivers().iterator();
		while(driverI.hasNext()){
			drivers.add(new DriverDTO(driverI.next()));
		}
		
		Iterator<Passenger> passengerI = muber.getPassengers().iterator();
		while(passengerI.hasNext()){
			passengers.add(new PassengerDTO(passengerI.next()));
		}
		
		Iterator<Trip> tripsI = muber.getTrips().iterator();
		while(tripsI.hasNext()){
			trips.add(new TripDTO(tripsI.next()));
		}
			
	}
	
	public Collection<DriverDTO> getDrivers() {
		return drivers;
	}
	
	public void setDrivers(Collection<DriverDTO> drivers) {
		this.drivers = drivers;
	}
	
	public Collection<PassengerDTO> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(Collection<PassengerDTO> passengers) {
		this.passengers = passengers;
	}
	
	public Collection<TripDTO> getTrips() {
		return trips;
	}
	
	public void setTrips(Collection<TripDTO> trips) {
		this.trips = trips;
	}
	
}
