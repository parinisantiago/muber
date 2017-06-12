package bd2.Muber.dto;

import java.util.Date;
import bd2.Muber.model.Driver;

public class DriverDTO {

	protected long id;
	protected String username;
	protected String pass;
	protected Date creationDate;
	private LicenseDTO license;
	private double averageScore;
	
	public DriverDTO(Driver driver){
		this.id = driver.getId();
		this.username = driver.getUsername();
		this.pass = driver.getPass();
		this.averageScore = driver.getAverageScore();
		this.creationDate = driver.getCreationDate();
		this.license = new LicenseDTO(driver.getLicense());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public LicenseDTO getLicense() {
		return license;
	}
	public void setLicense(LicenseDTO license) {
		this.license = license;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	
}
