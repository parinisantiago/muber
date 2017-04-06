package model;

import java.sql.Date;

public abstract class User {

	protected Long id;
	protected String username;
	protected String pass;
	protected Date creationDate;
	protected Trip[] trips;
	protected Score[] scores;

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
