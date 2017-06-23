package bd2.Muber.repositories;

import bd2.Muber.repositories.bi.ConductoresRepositoryBI;
import bd2.Muber.repositories.bi.PasajerosRepositoryBI;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;

public class RepositoryLocator {
	
	private PasajerosRepositoryBI pasajerosRepository;
	private static RepositoryLocator instance = null;
	private ConductoresRepositoryBI conductoresRepository;
	private ViajesRepositoryBI viajesRepository;
	private PuntajesRepositoryBI puntajesRepository;

	public static RepositoryLocator getInstance(){
		if(instance == null){
			instance = new RepositoryLocator();
		}
		return instance;
	}
	
	public ConductoresRepositoryBI getConductoresRepository(){
		return conductoresRepository;
	}
	public void setConductoresRepository(ConductoresRepositoryBI conductoresRepository) {
		this.conductoresRepository = conductoresRepository;
	}
	public PasajerosRepositoryBI getPasajerosRepository() {
		return pasajerosRepository;
	}
	
	public void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}

	public ViajesRepositoryBI getViajesRepository() {
		return viajesRepository;
	}

	public void setViajesRepository(ViajesRepositoryBI viajesRepository) {
		this.viajesRepository = viajesRepository;
	}

	public PuntajesRepositoryBI getPuntajesRepository() {
		return puntajesRepository;
	}

	public void setPuntajesRepository(PuntajesRepositoryBI puntajesRepository) {
		this.puntajesRepository = puntajesRepository;
	}
	

}
