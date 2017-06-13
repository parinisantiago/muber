package bd2.Muber.services.impl;

import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.dto.MuberDTO;
import bd2.Muber.dto.PassengerDTO;
import bd2.Muber.model.Muber;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.services.bi.PasajerosServiceBI;

public class PasajerosServiceImpl extends BaseServiceImpl implements PasajerosServiceBI{
	public Collection<PassengerDTO> getPasajeros(){
		PasajerosRepositoryBI pasajerosRepo = this.getPasajerosRepository();
		Session session = pasajerosRepo.getSession();
		Transaction tr = session.getTransaction();
		tr.begin();
		MuberDTO muber = this.getDtoFactory().getMuberDTO(pasajerosRepo.getPasajeros(session));
		@SuppressWarnings("unused")
		int uno = 1;
		tr.commit();
		session.close();
	    return muber.getPassengers();
	}
}
