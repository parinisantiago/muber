package bd2.Muber.repositories;

import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.repositories.impl.HibernatePasajerosRepository;

public class RepositoryLocator {
	
	private PasajerosRepositoryBI pasajerosRepository = null;
	private static RepositoryLocator instance = null;
	
	public static RepositoryLocator getInstance(){
		if(instance == null){
			instance = new RepositoryLocator();
		}
		return instance;
	}
	
	public PasajerosRepositoryBI getPasajerosRepository() {
		if(pasajerosRepository == null){
			pasajerosRepository = new HibernatePasajerosRepository();
		}
		return pasajerosRepository;
	}
	
	public void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}
	

}
