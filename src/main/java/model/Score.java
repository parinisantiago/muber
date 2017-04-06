package model;

public final class Score {
	
	private Long id;
	private String comment;
	private Integer score;
	private Passenger passenger;
	private Trip trip;
	
	public Score(Long id, String comment, Integer score, Passenger passenger, Trip trip) {
		super();
		this.id = id;
		this.comment = comment;
		this.score = score;
		this.passenger = passenger;
		this.trip = trip;
	}

	public Score() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	public Trip getTrip() {
		return trip;
	}
	
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
