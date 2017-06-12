package bd2.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

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
		aMap.put("result", "OK");
		return new Gson().toJson(aMap);
	}
	
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String pasajeros() {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("FROM Passenger");
			this.aMap.put("Passengers", query.list());
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
			
			
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String conductores() {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("FROM Driver");
			this.aMap.put("Drivers", query.list());
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}

	@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String viajesAbiertos() {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("FROM Trip T WHERE T.state = 'O' ");
			this.aMap.put("viajesAbiertos", query.list());
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/conductores/detalle", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String conductorDetalle(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("FROM Driver D WHERE D.id ="+request.getParameter("id"));
			this.aMap.put("conductorDetalle", query.list());
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String viajesNuevo(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Driver conductor = (Driver) session.get(Driver.class, Long.parseLong(request.getParameter("conductorId")));
			Trip viaje = new Trip(request.getParameter("origen"), request.getParameter("destino"), Double.parseDouble(request.getParameter("costoTotal")), Integer.parseInt(request.getParameter("cantidadPasajeros")), new Date(), conductor);
			session.persist(viaje);
			this.aMap.put("Result", "OK");
			this.json =  new Gson().toJson(aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String agregarPasajero(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Passenger pasajero = (Passenger) session.get(Passenger.class, Long.parseLong(request.getParameter("pasajeroId")));
			Trip viaje = (Trip) session.get(Trip.class, Long.parseLong(request.getParameter("viajeId")));
			viaje.addPassenger(pasajero);
			pasajero.addTrip(viaje);
			this.aMap.put("Result", "OK");
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	public String calificarViaje(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Passenger pasajero = (Passenger) session.get(Passenger.class,Long.parseLong(request.getParameter("pasajeroId")));
			Trip viaje = (Trip) session.get(Trip.class, Long.parseLong(request.getParameter("viajeId")));
			Score score = new Score(request.getParameter("comentario"), Integer.parseInt(request.getParameter("puntaje")));
			viaje.addScore(score);
			pasajero.addScore(score);
			this.aMap.put("Result", "OK");
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("pasajeroId",request.getParameter("pasajeroId"));
			this.aMap.put("viajeId",request.getParameter("viajeId"));
			this.aMap.put("comentario",request.getParameter("comentario"));
			this.aMap.put("puntaje",request.getParameter("puntaje"));
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String cargarCredito(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Passenger pasajero = (Passenger) session.get(Passenger.class, Long.parseLong(request.getParameter("pasajeroId")));
			pasajero.addCash(Double.parseDouble(request.getParameter("monto")));
			this.aMap.put("Result", "OK");
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	
	@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	public String finalizarViaje(WebRequest request) {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Trip viaje = (Trip) session.get(Trip.class,Long.parseLong(request.getParameter("viajeId")));
			if(viaje.finished()) throw new Exception("El viaje ya a sido finalizado");
			viaje.finish();
			aMap.put("Result", "OK");
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
	@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String top10Conductores() {
		try{
			this.aMap = new HashMap<String, Object>();
			Session session = this.getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("SELECT D FROM Driver D, Trip T WHERE T.state = 'F' ORDER BY D.averageScore");
			query.setMaxResults(10);
			this.aMap.put("Result", "OK");
			this.aMap.put("Top 10", query.list());
			this.json =  this.getGson().toJson(this.aMap);
			tr.commit();
			session.close();
		} catch(Exception e){
			this.aMap.put("error", e.getMessage());
			return this.getGson().toJson(this.aMap);
		}
		return this.json;
	}
}
