package bd2.Muber.services.impl;

import bd2.Muber.dto.ScoreDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Score;
import bd2.Muber.repositories.bi.PuntajesRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;
import bd2.Muber.services.bi.PuntajesServiceBI;

public class PuntajesServiceImpl extends BaseServiceImpl implements PuntajesServiceBI{

	@Override
	public ScoreDTO calificarViaje(Score score) {
		PuntajesRepositoryBI puntajeRepo = this.getPuntajesRepository();
		ScoreDTO scoreDTO = new ScoreDTO(puntajeRepo.calificarViaje(score));
		return scoreDTO;
	}

}
