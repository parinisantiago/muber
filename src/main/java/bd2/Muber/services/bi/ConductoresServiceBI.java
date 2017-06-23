package bd2.Muber.services.bi;

import java.util.Collection;

import bd2.Muber.dto.DriverDTO;

public interface ConductoresServiceBI {
	public Collection<DriverDTO> getConductores();
	public DriverDTO conductorDetalle(String id);
	public Collection<DriverDTO> top10Conductores();

}
