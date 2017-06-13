package bd2.Muber.services.impl;

import bd2.Muber.dto.DTOFactory;
import bd2.Muber.repositories.RepositoryLocator;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;

public class BaseServiceImpl {
	
	private DTOFactory dtoFactory;
	private PasajerosRepositoryBI pasajerosRepository = null;
	
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
}
