package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.repositories.bi.ConductoresRepositoryBI;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;

public class BaseServiceImpl {
	
	private DTOFactory dtoFactory;
	private PasajerosRepositoryBI pasajerosRepository = null;
	private ConductoresRepositoryBI conductoresRepository = null;
	private ViajesRepositoryBI viajesRepository = null;
	private PuntajesRepositoryBI puntajesRepository = null;
	
	@SuppressWarnings("static-access")
	public DTOFactory getDtoFactory(){
		return this.dtoFactory.getInstance();
	}
	
	public void setDtoFactory(DTOFactory dtoFactory){
		this.dtoFactory = dtoFactory;
	}
	
	public PasajerosRepositoryBI getPasajerosRepository() {
		if(pasajerosRepository == null){
			pasajerosRepository = RepositoryLocator.getInstance().getPasajerosRepository();
		}
		return pasajerosRepository;
	}

	public void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}

	public ConductoresRepositoryBI getConductoresRepository() {
		if(conductoresRepository == null){
			conductoresRepository = RepositoryLocator.getInstance().getConductoresRepository();
		}
		return conductoresRepository;
	}

	public void setConductoresRepository(ConductoresRepositoryBI conductoresRepository) {
		this.conductoresRepository = conductoresRepository;
	}

	public ViajesRepositoryBI getViajesRepository() {
		if(viajesRepository == null){
			viajesRepository = RepositoryLocator.getInstance().getViajesRepository();
		}
		return viajesRepository;	
		}

	public void setViajesRepository(ViajesRepositoryBI viajesRepository) {
		this.viajesRepository = viajesRepository;
	}

	public PuntajesRepositoryBI getPuntajesRepository() {
		if(puntajesRepository == null){
			puntajesRepository = RepositoryLocator.getInstance().getPuntajesRepository();
		}
		return puntajesRepository;		}

	public void setPuntajesRepository(PuntajesRepositoryBI puntajesRepository) {
		this.puntajesRepository = puntajesRepository;
	}
}
