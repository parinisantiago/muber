package bd2.Muber.repositories.bi;

import java.util.Collection;

import bd2.Muber.model.Driver;
import bd2.Muber.model.Muber;

public interface ConductoresRepositoryBI extends BaseRepositoryBI{
	public Muber getConductores();
	public Driver conductorDetalle(String id);
	public Collection<Driver> top10Conductores();
}
