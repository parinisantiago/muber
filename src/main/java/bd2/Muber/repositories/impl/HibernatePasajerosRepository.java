package bd2.Muber.repositories.impl;

import org.hibernate.Query;

import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;

public class HibernatePasajerosRepository extends BaseHibernateRepository implements PasajerosRepositoryBI{
	public  Muber getPasajeros(){
		Query query = this.getSession().createQuery("FROM Muber");
		Muber muber = (Muber) query.list().iterator().next();
		return muber;
	}

	@Override
	public Passenger cargarCredito(Passenger passenger) {
		Passenger myPassenger = (Passenger) this.getSession().createQuery("FROM Passenger P WHERE id="+passenger.getId()).list().iterator().next();
		myPassenger.addCash(passenger.getCash());
		return myPassenger;
	}
}
