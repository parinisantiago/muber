package bd2.Test;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import bd2.Muber.model.Driver;
import bd2.Muber.model.License;
import bd2.Muber.model.Muber;
import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;

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
	private static Muber muber;
	
	public static void main(String[] args){		
		try{
			setUp();
			Long idRoberto = persist(roberto);
			finishTrip(idRoberto);
			setUpScore();
			pay();	
			muber =new Muber();
			persistMuber();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	protected static void persistMuber(){
		try{
			session = sf.openSession();
			tx = session.beginTransaction();
			long id = 1;
			roberto = (Driver)session.get(Driver.class, id);
			id = 2;
			margarita = (Passenger)session.get(Passenger.class, id);
			id = 3;
			german = (Passenger)session.get(Passenger.class, id);
			id = 4;
			alicia = (Passenger)session.get(Passenger.class, id);
			id = 1;
			tripRoberto = (Trip)session.get(Trip.class, id);
			muber.addTrip(tripRoberto);
			muber.addPassenger(margarita);
			muber.addPassenger(german);
			muber.addPassenger(alicia);
			muber.addDriver(roberto);
			session.persist(muber);
			tx.commit();
			session.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	protected static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
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

	private static void setUp() {
		cfg = new Configuration().configure("hibernate.cfg.xml");
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

	public static Muber getMuber() {
		return muber;
	}

	public static void setMuber(Muber muber) {
		Main.muber = muber;
	}

}