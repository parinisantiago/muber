package bd2.Muber.services;

import bd2.Muber.services.bi.PasajerosServiceBI;
import bd2.Muber.services.impl.PasajerosServiceImpl;

public class ServiceLocator {
	private PasajerosServiceBI pasajerosService = null;
	private static ServiceLocator instance = null;
	public static ServiceLocator getInstance(){
		if(instance == null){
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	public PasajerosServiceBI getPasajerosService(){
		if(pasajerosService == null){
			pasajerosService = new PasajerosServiceImpl();
		}
		return pasajerosService;
	}

	public void setPasajerosService(PasajerosServiceBI pasajerosService) {
		this.pasajerosService = pasajerosService;
	}
}
