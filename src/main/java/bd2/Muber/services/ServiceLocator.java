package bd2.Muber.services;

import bd2.Muber.services.bi.ConductoresServiceBI;
import bd2.Muber.services.bi.PasajerosServiceBI;
import bd2.Muber.services.bi.PuntajesServiceBI;
import bd2.Muber.services.bi.ViajesServiceBI;
import bd2.Muber.services.impl.ConductoresServiceImpl;
import bd2.Muber.services.impl.PasajerosServiceImpl;
import bd2.Muber.services.impl.PuntajesServiceImpl;
import bd2.Muber.services.impl.ViajesServiceImpl;

public class ServiceLocator {
	private PasajerosServiceBI pasajerosService;
	private ConductoresServiceBI conductoresService;
	private ViajesServiceBI viajesService;
	private PuntajesServiceBI puntajesService;
	private static ServiceLocator instance = null;
	public static ServiceLocator getInstance(){
		if(instance == null){
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	public PasajerosServiceBI getPasajerosService(){
		return pasajerosService;
	}

	public void setPasajerosService(PasajerosServiceBI pasajerosService) {
		this.pasajerosService = pasajerosService;
	}

	public ConductoresServiceBI getConductoresService() {
		return conductoresService;	
	}

	public void setConductoresService(ConductoresServiceBI conductoresService) {
		this.conductoresService = conductoresService;
	}

	public ViajesServiceBI getViajesService() {
		return viajesService;	
	}

	public void setViajesService(ViajesServiceBI viajesService) {
		this.viajesService = viajesService;
	}

	public PuntajesServiceBI getPuntajesService() {
		return puntajesService;		
		}

	public void setPuntajesService(PuntajesServiceBI puntajesService) {
		this.puntajesService = puntajesService;
	}
}
