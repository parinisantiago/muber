package bd2.Muber.services.bi;

import java.util.Collection;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.dto.ScoreDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

public interface ViajesServiceBI {
	public Collection<TripDTO> viajesAbiertos();

	public TripDTO viajesNuevo(Trip trip);

	public PassengerDTO agregarPasajero(Passenger passenger);

	public ScoreDTO calificarViaje(Score score);

	public TripDTO finalizarViaje(Trip trip);

}
