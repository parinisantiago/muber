package bd2.Muber.repositories.impl;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;

public class HibernateViajesRepository extends BaseHibernateRepository implements ViajesRepositoryBI{

	@Override
	public Collection<Trip> viajesAbiertos() {
		Query query =  this.getSession().createQuery("FROM Trip T WHERE T.state = 'O' ");
		@SuppressWarnings("unchecked")
		Collection<Trip> trips = query.list();
		return trips;	
	}

	@Override
	public Trip viajesNuevo(Trip trip) {
		@SuppressWarnings("unchecked")
		Collection<Driver> drivers= this.getSession().createQuery("FROM Driver D, Trip T WHERE T.state='O' AND D.id ="+trip.getId()).list();
		if(!drivers.isEmpty()) return null;
		
		Driver conductor = (Driver) this.getSession().createQuery("FROM Driver D WHERE D.id ="+trip.getId()).list().iterator().next();
		if(conductor == null) return null;
		Trip viaje = new Trip(trip.getOrigin(), trip.getDestiny(), trip.getCost(), trip.getMaxPassengers(), new Date(), conductor);
		Muber muber = (Muber) this.getSession().createQuery("FROM Muber").iterate().next();
		muber.addTrip(viaje);
		return viaje;
	}

	@Override
	public Passenger agregarPasajero(Passenger passenger) {
		Trip trip = (Trip) this.getSession().createQuery("FROM Trip T WHERE T.id="+passenger.getIdTrip()).list().iterator().next();
		if(trip.tripIsFull()) return null;
		if(trip.finished()) return null;
		Passenger myPassanger = (Passenger) this.sessionFactory.getCurrentSession().createQuery("FROM Passenger P WHERE P.id="+passenger.getId()).list().iterator().next();
		trip.addPassenger(myPassanger);
		myPassanger.addTrip(trip);
		return myPassanger;
	}

	@Override
	public Score calificarViaje(Score score) {
		Score myScore= new Score(score.getComment(),score.getScore());
		Trip trip = (Trip) this.getSession().createQuery("FROM Trip T WHERE T.id="+score.getIdTrip()).list().iterator().next();
		if(!trip.finished()) return null;
		Passenger passenger=(Passenger) this.getSession().createQuery("FROM Passenger P WHERE P.id="+score.getIdPassenger()).list().iterator().next();
		trip.addScore(myScore);
		passenger.addScore(myScore);
		return myScore;
	}

	@Override
	public Trip finalizarViaje(Trip trip) {
		Trip Mytrip = (Trip) this.getSession().createQuery("FROM Trip T WHERE T.id="+trip.getId()).list().iterator().next();
		if(Mytrip.finished())return null;
		Mytrip.finish();
		return Mytrip;
	}


}
