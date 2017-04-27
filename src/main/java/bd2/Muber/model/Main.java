package bd2.Muber.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

public class Main {

	private static SessionFactory sf;
	private static Configuration cfg; 
	private static License licenseRoberto;
	private static Trip tripRoberto;
	private static Driver roberto;
	private static Passenger german;
	private static Passenger alicia;
	private static Passenger margarita;
	private static Score scoreGerman;
	private static Score scoreAlicia;
	private static Score scoreMargarita;
	private static Session session;
	private static Transaction tx;
	
	public static void main(String[] args){		
		try{
			/*setUp();
			Long idRoberto = persist(roberto);
			finishTrip(idRoberto);
			setUpScore();
			pay();*/
			POJO pojo = new POJO();
			Map<String, Object> aMap = new HashMap<String, Object>();
			aMap.put("result", "OK");
			aMap.put("pojo", pojo);
			String json = new Gson().toJson(aMap);
			System.out.println(json);
			Session session = getSession();
			Transaction tr = session.getTransaction();
			tr.begin();
			Query query = session.createQuery("FROM Passenger");
			aMap.put("Passengers", query.list());
			@SuppressWarnings("unused")
			int in = 1;
			tr.commit();
			session.close();

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	protected static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
	
	private static void pay() {
		session = sf.openSession();
		tx = session.beginTransaction();
		long id = 1;
		tripRoberto = (Trip)session.get(Trip.class, id);
		double cost = tripRoberto.getCost();
		Iterator<Passenger> passengersIterator = tripRoberto.getPassengers().iterator();
		
		while(passengersIterator.hasNext()){
			passengersIterator.next().pay(cost);
		}
		
		tx.commit();
		session.close();
	}

	private static void finishTrip(Long id) {
		session = sf.openSession();
		tx = session.beginTransaction();
		Driver roberto = (Driver) session.get(Driver.class, id);
		Trip tripRoberto = roberto.getTrips().iterator().next();
		tripRoberto.finish();
		
		tx.commit();
		session.close();
	}

	private static Long persist(Object o) {
		session = sf.openSession();
		tx = session.beginTransaction();
		Long id = (Long) session.save(o);
		tx.commit();
		session.close();
		return id;
	}

	@SuppressWarnings("deprecation")
	private static void setUp() {
		cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		
		setUpLicense();
		setUpDriver();
		setUpPassengers();
		setUpTrip();

	}

	private static void setUpScore() {
		scoreGerman = new Score("Comentario de German", 5);
		scoreAlicia = new Score("Comentario de Alicia", 4);
		scoreMargarita = new Score("Comentario de Margarita", 4);
		scoreTrip();
		
	}

	private static void scoreTrip() {
		session = sf.openSession();
		tx = session.beginTransaction();
		Long id= (long) 4;
		margarita = (Passenger)session.get(Passenger.class, id);
		id = (long) 3;
		alicia = (Passenger)session.get(Passenger.class, id);
		id = (long) 2;
		german = (Passenger)session.get(Passenger.class, id);
		id = (long) 1;
		tripRoberto = (Trip)session.get(Trip.class, id);
		margarita.addScore(scoreMargarita);
		alicia.addScore(scoreAlicia);
		german.addScore(scoreGerman);
		tripRoberto.addScore(scoreAlicia);
		tripRoberto.addScore(scoreGerman);
		tripRoberto.addScore(scoreMargarita);
		session.save(scoreMargarita);
		session.save(scoreAlicia);
		session.save(scoreGerman);
		tx.commit();
		session.close();
	}

	private static void setUpPassengers() {
		german = new Passenger("german", "german", new Date(), 1500.00);
		alicia = new Passenger("alicia", "alicia", new Date(), 1500.00);
		margarita = new Passenger("margarita", "margarita", new Date(), 1500.00);
	}

	private static void setUpTrip() {
		tripRoberto = new Trip("La Plata", "Tres Arroyos", 900.00, 4, new Date(), roberto);
		roberto.addTrip(tripRoberto);
		tripRoberto.addPassenger(german);
		tripRoberto.addPassenger(alicia);
		tripRoberto.addPassenger(margarita);
		german.addTrip(tripRoberto);
		alicia.addTrip(tripRoberto);
		margarita.addTrip(tripRoberto);
	}

	private static void setUpDriver() {
		roberto= new Driver("roberto", "roberto", new Date(), licenseRoberto);
	}

	private static void setUpLicense() {
		licenseRoberto = new License(786913,new Date());
	}

}