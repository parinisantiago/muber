package bd2.web;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;
import bd2.Muber.services.ServiceLocator;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	private Map<String, Object> aMap = new HashMap<String, Object>();
	private String json;
	
	protected Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	private Gson getGson(){
		 final GsonBuilder builder = new GsonBuilder();
		 builder.excludeFieldsWithoutExposeAnnotation();
		 final Gson gson = builder.create();
		 return gson;
	}
	
	@RequestMapping(value = "/example", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String prueba() {
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("result", "funciona");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Passengers", ServiceLocator.getInstance().getPasajerosService().getPasajeros());
			this.json =  this.getGson().toJson(this.aMap);	
		} catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String conductores() {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Drivers", ServiceLocator.getInstance().getConductoresService().getConductores());
			this.json =  this.getGson().toJson(this.aMap);	
		} catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}

	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String viajesAbiertos() {
		try{
			this.aMap = new HashMap<String, Object>();
			Collection<TripDTO> trips =ServiceLocator.getInstance().getViajesService().viajesAbiertos();
			if(trips.isEmpty()){
				this.aMap.put("Trips:", "no hay viajes abiertos");
			}else{
			this.aMap.put("Trips:", ServiceLocator.getInstance().getViajesService().viajesAbiertos());
			}
			this.json =  this.getGson().toJson(this.aMap);	
		} catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String conductorDetalle(@RequestParam("id") String id) {
		try{
			DriverDTO driver = ServiceLocator.getInstance().getConductoresService().conductorDetalle(id);
			this.aMap = new HashMap<String, Object>();
			if(driver == null){
				this.aMap.put("Drivers", "no hay un condyctor");
			} else {
				this.aMap.put("Drivers", driver);
			}
			this.json =  this.getGson().toJson(this.aMap);
		}catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error","no existe el conductor solicitado");
			return this.getGson().toJson(this.aMap);
		}
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error",e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String viajesNuevo(@RequestBody Trip trip) {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Trip", ServiceLocator.getInstance().getViajesService().viajesNuevo(trip));
			this.json =  this.getGson().toJson(this.aMap);	
		} 
		catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "El conductor no existe");
			return this.getGson().toJson(this.aMap);
		}	
		catch(NullPointerException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "El conductor ya posee un viaje abierto");
			return this.getGson().toJson(this.aMap);
		}
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String agregarPasajero(@RequestBody Passenger passenger) {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Pasajero", ServiceLocator.getInstance().getViajesService().agregarPasajero(passenger));
			this.json =  this.getGson().toJson(this.aMap);	
		} 
		catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "El pasajero o viaje no existe");
			return this.getGson().toJson(this.aMap);
		}	
		catch(NullPointerException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "No pueden agregarse más pasajeros a este viaje o el viaje ya ha finalizado");
			return this.getGson().toJson(this.aMap);
		}
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(@RequestBody Score score) {
		try{	
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Calificacion:", ServiceLocator.getInstance().getViajesService().calificarViaje(score));
			this.json =  this.getGson().toJson(this.aMap);	
		} 
		catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "No existe el pasajero o el viaje");
			return this.getGson().toJson(this.aMap);
		}	
		catch(NullPointerException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "El pasajero ya ha puntuado este viaje o este aun no ha finalizado");
			return this.getGson().toJson(this.aMap);
		}catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		
		return this.json;
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String cargarCredito(@RequestBody Passenger passenger) {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Passenger:", ServiceLocator.getInstance().getPasajerosService().cargarCredito(passenger));
			this.json =  this.getGson().toJson(this.aMap);
		} 
		catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "No existe el pasajero");
			return this.getGson().toJson(this.aMap);
		}	
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String finalizarViaje(@RequestBody Trip trip) {
		try{
			
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Trip:", ServiceLocator.getInstance().getViajesService().finalizarViaje(trip));
			this.json =  this.getGson().toJson(this.aMap);
			
		}
		catch(NoSuchElementException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "No existe el viaje");
			return this.getGson().toJson(this.aMap);
		}
		catch(NullPointerException e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", "El viaje ya a sido finalizado");
			return this.getGson().toJson(this.aMap);
		}
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String top10Conductores() {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Drivers:", ServiceLocator.getInstance().getConductoresService().top10Conductores());
			this.json =  this.getGson().toJson(this.aMap);
		} 
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	@RequestMapping(value = "/pasajero", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String crearPasajero(@RequestBody Passenger pasajero) {
		try{
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("Pasajero:", ServiceLocator.getInstance().getPasajerosService().nuevo(pasajero));
			this.json =  this.getGson().toJson(this.aMap);
		} 
		catch(Exception e){
			this.aMap = new HashMap<String, Object>();
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	
}
