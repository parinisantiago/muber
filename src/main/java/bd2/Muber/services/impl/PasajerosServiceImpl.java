package bd2.Muber.services.impl;

import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.MuberDTO;
import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.services.bi.PasajerosServiceBI;

public class PasajerosServiceImpl extends BaseServiceImpl implements PasajerosServiceBI{
	public Collection<PassengerDTO> getPasajeros(){
		PasajerosRepositoryBI pasajerosRepo = this.getPasajerosRepository();

		MuberDTO muber = this.getDtoFactory().getMuberDTO(pasajerosRepo.getPasajeros());

	    return muber.getPassengers();
	}

	@Override
	public PassengerDTO cargarCredito(Passenger passenger) {
		PasajerosRepositoryBI pasajerosRepo = this.getPasajerosRepository();

		PassengerDTO passengetDTO = this.getDtoFactory().getPassengerDTO(pasajerosRepo.cargarCredito(passenger));

	    return passengetDTO;
	}
}
