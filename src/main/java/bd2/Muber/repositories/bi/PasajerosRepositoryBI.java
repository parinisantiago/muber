package bd2.Muber.repositories.bi;

import org.hibernate.Session;

import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;

public interface PasajerosRepositoryBI extends BaseRepositoryBI{
	public Muber getPasajeros();

	public Passenger cargarCredito(Passenger passenger);
}
