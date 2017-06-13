package bd2.Muber.repositories.bi;

import org.hibernate.Session;

import bd2.Muber.model.Muber;

public interface PasajerosRepositoryBI extends BaseRepositoryBI{
	public Muber getPasajeros(Session session);
}
