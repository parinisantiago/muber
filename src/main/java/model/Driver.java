package model;

import java.sql.Date;

public class Driver extends User {
	
	private License license;

	public Driver() {
		super();
	}

	public Driver(License license, Long id, String username, String pass, Date creationDate) {
		this.pass = pass;
		this.id = id;
		this.username = username;
		this.creationDate = creationDate;
		this.license = license;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
	
}
