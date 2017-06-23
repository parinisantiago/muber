package bd2.Muber.repositories.impl;

import java.util.Collection;

import org.hibernate.Query;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Muber;
import bd2.Muber.repositories.bi.ConductoresRepositoryBI;

public class HibernateConductoresRepository  extends BaseHibernateRepository implements ConductoresRepositoryBI{
		
		public  Muber getConductores(){
			Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Muber");
			Muber muber = (Muber) query.list().iterator().next();
			return muber;
		}

		public Driver conductorDetalle(String id) {
			Query query = this.sessionFactory.getCurrentSession().createQuery("FROM Driver D WHERE D.id ="+id);
			Driver driver = (Driver) query.list().iterator().next();
			return driver;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<Driver> top10Conductores() {
			Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT D FROM Driver D WHERE D.id NOT IN (SELECT T.driver.id FROM Trip T WHERE T.state = 'O') ORDER BY D.averageScore");
			query.setMaxResults(10);
			return query.list();
		}
}
