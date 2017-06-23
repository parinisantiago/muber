package bd2.Muber.repositories.impl;

import java.util.Collection;

import bd2.Muber.model.Passenger;
import bd2.Muber.model.Score;
import bd2.Muber.model.Trip;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;

public class HibernatePuntajesRepository extends BaseHibernateRepository implements PuntajesRepositoryBI{

	@Override
	public Score calificarViaje(Score score) {
		@SuppressWarnings("unchecked")
		Collection<Score> scores = this.getSession().createQuery("FROM Score S, Trip T, Passenger P WHERE T.id="+score.getIdTrip()+" AND P.id="+score.getIdPassenger()).list();
		if(!scores.isEmpty()) return null;
		Score myScore= new Score(score.getComment(),score.getScore());
		Trip trip = (Trip) this.getSession().createQuery("FROM Trip T WHERE T.id="+score.getIdTrip()).list().iterator().next();
		Passenger passenger=(Passenger) this.getSession().createQuery("FROM Passenger P WHERE P.id="+score.getIdPassenger()).list().iterator().next();
		trip.addScore(myScore);
		passenger.addScore(myScore);
		return myScore;
	}

}
