package bd2.Muber.dto;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

public class TripDTO {
	
	private String state;
	private String origin;
	private String destiny;
	private Double cost;
	private int maxPassengers;
	private Date dateTrip;
	private Collection<ScoreDTO> scores;
	private Driver driver;
	private long id;
	
	public TripDTO(Trip trip){
    	this.scores = new HashSet<ScoreDTO>();
		this.state = trip.getState();
		this.origin = trip.getOrigin();
		this.destiny = trip.getDestiny();
		this.cost = trip.getCost();
		this.maxPassengers = trip.getMaxPassengers();
		this.dateTrip = trip.getDateTrip();
		this.id = trip.getId();
		Iterator<Score> scoreIterator = trip.getScores().iterator();
		while(scoreIterator.hasNext()){
			scores.add(new ScoreDTO(scoreIterator.next()));
		}
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
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
	
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Date getDateTrip() {
		return dateTrip;
	}
	
	public void setDateTrip(Date dateTrip) {
		this.dateTrip = dateTrip;
	}
	
	public Collection<ScoreDTO> getScores() {
		return scores;
	}
	
	public void setScores(Collection<ScoreDTO> scores) {
		this.scores = scores;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
