package bd2.Muber.dto;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;

public class PassengerDTO {
	
	private long id;
	private String username;
	private String pass;
	private Date creationDate;
	private double cash;
    private Collection<ScoreDTO> scores;
    
    public PassengerDTO(Passenger passenger){
    	this.id = passenger.getId();
    	this.cash = passenger.getCash();
    	this.creationDate = passenger.getCreationDate();
    	this.username = passenger.getUsername();
    	this.pass = passenger.getPass();
		Iterator<Score> scoreIterator = passenger.getScores().iterator();
		while(scoreIterator.hasNext()){
			scores.add(new ScoreDTO(scoreIterator.next()));
		}
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public Collection<ScoreDTO> getScores() {
		return scores;
	}
	public void setScores(Collection<ScoreDTO> scores) {
		this.scores = scores;
	}

}
