package bd2.Muber.model;

import com.google.gson.annotations.Expose;

public final class Score {
	@Expose
	private String comment;
	@Expose
	private Integer score;
	@Expose
	private Long oid;
	
	public Score() {
		super();
	}
	
	public Score(String comment, Integer score) {
		super();
		this.comment = comment;
		this.score = score;
	}
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
/*
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}*/
}