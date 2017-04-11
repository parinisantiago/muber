package model;

public class Driver extends User {
	
	private Trip[] trips;
	private License license;

	public Driver() {
		super();
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public Trip[] getTrips() {
		return trips;
	}

	public void setTrips(Trip[] trips) {
		this.trips = trips;
	}
	
}
