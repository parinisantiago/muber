package model;

public class Passenger extends User {

	private Float cash;
	private Trip[] trips;
    private Score[] scores;

	public Passenger() {
		super();
	}

	public Float getCash() {
		return cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
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
