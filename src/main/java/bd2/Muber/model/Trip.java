package bd2.Muber.model;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class Trip {
	
	private String state;
	private String origin;
	private String destiny;
	private Double cost;
	private int maxPassengers;
	private Date dateTrip;
	private Collection<Passenger> passengers;
	private Collection<Score> scores;
	private Driver driver;
	private Long oid;
	
	public Trip() {
		super();
	}
	
	public Trip(String origin, String destiny, Double cost, int maxPassengers, Date dateTrip, Driver driver) {
		super();
		this.origin = origin;
		this.destiny = destiny;
		this.cost = cost;
		this.maxPassengers = maxPassengers;
		this.dateTrip = dateTrip;
		this.driver = driver;
		this.passengers = new HashSet<Passenger>();
		this.scores = new HashSet<Score>();
		this.state="O";
	}

	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestiny() {
		return destiny;
	}
	
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	public Date getDateTrip() {
		return dateTrip;
	}
	
	public void setDateTrip(Date dateTrip) {
		this.dateTrip = dateTrip;
	}

	public Collection<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Collection<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Collection<Score> getScores() {
		return scores;
	}

	public void setScores(Collection<Score> scores) {
		this.scores = scores;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public void addPassenger(Passenger passenger){
		this.passengers.add(passenger);
	}

	public void addScore(Score score){
		this.scores.add(score);
	}
	
	public boolean finished(){
		return (this.state.equals("F"));
	}
	
	public void finish() {
		this.state = "F";
	}

	public int averageScore() {
		Iterator<Score> scoreIterator = this.getScores().iterator();
		int score = 0;
		
		while(scoreIterator.hasNext()){
			score = score + scoreIterator.next().getScore();
		}
		return score;
	}
}