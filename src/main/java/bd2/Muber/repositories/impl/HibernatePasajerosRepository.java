package bd2.Muber.repositories.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Muber;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;

public class HibernatePasajerosRepository extends BaseHibernateRepository implements PasajerosRepositoryBI{
	public  Muber getPasajeros(Session session){
		Query query = session.createQuery("FROM Muber");
		Muber muber = (Muber) query.list().iterator().next();
		return muber;
	}
}
