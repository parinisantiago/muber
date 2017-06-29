package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.repositories.bi.ConductoresRepositoryBI;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;

public class BaseServiceImpl {
	
	private DTOFactory dtoFactory;
	private PasajerosRepositoryBI pasajerosRepository;
	private ConductoresRepositoryBI conductoresRepository;
	private ViajesRepositoryBI viajesRepository;
	private PuntajesRepositoryBI puntajesRepository;
	
	@SuppressWarnings("static-access")
	public DTOFactory getDtoFactory(){
		return this.dtoFactory.getInstance();
	}
	
	public void setDtoFactory(DTOFactory dtoFactory){
		this.dtoFactory = dtoFactory;
	}
	
	public PasajerosRepositoryBI getPasajerosRepository() {
		return pasajerosRepository;
	}

	public void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}

	public ConductoresRepositoryBI getConductoresRepository() {
		return conductoresRepository;
	}

	public void setConductoresRepository(ConductoresRepositoryBI conductoresRepository) {
		this.conductoresRepository = conductoresRepository;
	}

	public ViajesRepositoryBI getViajesRepository() {
		return viajesRepository;	
		}

	public void setViajesRepository(ViajesRepositoryBI viajesRepository) {
		this.viajesRepository = viajesRepository;
	}

	public PuntajesRepositoryBI getPuntajesRepository() {
		return puntajesRepository;		}

	public void setPuntajesRepository(PuntajesRepositoryBI puntajesRepository) {
		this.puntajesRepository = puntajesRepository;
	}
}
