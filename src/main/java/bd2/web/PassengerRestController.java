package bd2.web;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.google.gson.Gson;

@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc

public class PassengerRestController {

		@SuppressWarnings("deprecation")
		protected Session getSession() {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate/hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			return session;
		}

		@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String pasajeros() {
			Map<String, Object> aMap = new HashMap<String, Object>();
			aMap.put("result", "OK");
			try{
				
				Session session = this.getSession();
				Transaction tr = session.getTransaction();
				tr.begin();
				Query query = session.createQuery("FROM Passenger");
				aMap.put("Passengers", query.list());
				tr.commit();
				session.close();
				
				
			} catch(Exception e){
				System.out.println(e.getMessage());
				aMap.put("error", e.getMessage());
				return new Gson().toJson(aMap);
			}
			return new Gson().toJson(aMap);
		}
	

}
