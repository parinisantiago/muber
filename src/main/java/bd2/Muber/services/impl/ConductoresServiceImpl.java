package bd2.Muber.services.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import bd2.Muber.dto.DriverDTO;
import bd2.Muber.dto.MuberDTO;
import bd2.Muber.dto.TripDTO;
import bd2.Muber.model.Driver;
import bd2.Muber.model.Trip;
import bd2.Muber.repositories.bi.ConductoresRepositoryBI;
import bd2.Muber.repositories.bi.ViajesRepositoryBI;
import bd2.Muber.services.bi.ConductoresServiceBI;

public class ConductoresServiceImpl  extends BaseServiceImpl implements ConductoresServiceBI{

	public Collection<DriverDTO> getConductores() {
		ConductoresRepositoryBI conductoresRepo = this.getConductoresRepository();

		MuberDTO muber = this.getDtoFactory().getMuberDTO(conductoresRepo.getConductores());

	    return muber.getDrivers();
	}

	@Override
	public DriverDTO conductorDetalle(String id) {
		ConductoresRepositoryBI conductoresRepo = this.getConductoresRepository();

		DriverDTO driver = this.getDtoFactory().getDriverDTO(conductoresRepo.conductorDetalle(id));

	    return driver;
	}

	@Override
	public Collection<DriverDTO> top10Conductores() {
		ConductoresRepositoryBI conductoresRepo = this.getConductoresRepository();

		Collection<Driver> drivers = conductoresRepo.top10Conductores();
		Collection<DriverDTO>driversDTO = new HashSet<DriverDTO>();

		Iterator<Driver> driversI = drivers.iterator();
		while(driversI.hasNext()){
			driversDTO.add(this.getDtoFactory().getDriverDTO(driversI.next()));
		}
	    return driversDTO;
	}

}
