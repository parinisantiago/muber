package bd2.Muber.services.bi;

import java.util.Collection;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Passenger;

public interface PasajerosServiceBI {
	public Collection<PassengerDTO> getPasajeros();

	public PassengerDTO cargarCredito(Passenger passenger);

	public PassengerDTO nuevo(Passenger pasajero);
}
