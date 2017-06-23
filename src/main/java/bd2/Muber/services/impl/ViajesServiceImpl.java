package bd2.Muber.services.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.dto.ScoreDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;
import bd2.Muber.services.bi.ViajesServiceBI;

public class ViajesServiceImpl extends BaseServiceImpl implements ViajesServiceBI{

	@Override
	public Collection<TripDTO> viajesAbiertos() {
		ViajesRepositoryBI viajesRepo = this.getViajesRepository();

		Collection<Trip> trips = viajesRepo.viajesAbiertos();
		Collection<TripDTO>tripsDTO = new HashSet<TripDTO>();

		Iterator<Trip> tripsI = trips.iterator();
		while(tripsI.hasNext()){
			tripsDTO.add(this.getDtoFactory().getTripDTO(tripsI.next()));
		}
	    return tripsDTO;
	}

	@Override
	public TripDTO viajesNuevo(Trip trip) {
		ViajesRepositoryBI viajesRepo = this.getViajesRepository();
		TripDTO tripDTO = this.getDtoFactory().getTripDTO(viajesRepo.viajesNuevo(trip));
		return tripDTO;
	}

	@Override
	public PassengerDTO agregarPasajero(Passenger passenger) {
		ViajesRepositoryBI viajesRepo = this.getViajesRepository();
		PassengerDTO passengerDTO = this.getDtoFactory().getPassengerDTO(viajesRepo.agregarPasajero(passenger));
		return passengerDTO;
	}

	@Override
	public ScoreDTO calificarViaje(Score score) {
		ViajesRepositoryBI viajesRepo = this.getViajesRepository();
		ScoreDTO scoreDTO = this.getDtoFactory().getScoreDTO(viajesRepo.calificarViaje(score));
		return scoreDTO;
	}

	@Override
	public TripDTO finalizarViaje(Trip trip) {
		ViajesRepositoryBI viajesRepo = this.getViajesRepository();
		TripDTO tripDTO = this.getDtoFactory().getTripDTO(viajesRepo.finalizarViaje(trip));
		return tripDTO;
	}

}
