package bd2.Muber.repositories.bi;

import java.util.Collection;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

public interface ViajesRepositoryBI extends BaseRepositoryBI{
	public Collection<Trip> viajesAbiertos();

	public Trip viajesNuevo(Trip trip);

	public Passenger agregarPasajero(Passenger passenger);

	public Score calificarViaje(Score score);

	public Trip finalizarViaje(Trip trip);
}
