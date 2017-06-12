package bd2.Muber.dto;

import bd2.Muber.model.Driver;
import bd2.Muber.model.License;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

public class DTOFactory {

	public DriverDTO getDriverDTO(Driver driver) {
		return new DriverDTO(driver);
	}
	
	public LicenseDTO getLicenseDTO(License license) {
		return new LicenseDTO(license);
	}
	
	public MuberDTO getMuberDTO(Muber muber) {
		return new MuberDTO(muber);
	}
	
	public PassengerDTO getPassengerDTO(Passenger passenger) {
		return new PassengerDTO(passenger);
	}
	
	public ScoreDTO getScoreDTO(Score score) {
		return new ScoreDTO(score);
	}
	
	public TripDTO getTripDTO(Trip trip) {
		return new TripDTO(trip);
	}
}
