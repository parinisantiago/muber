package bd2.Muber.dto;

import java.util.Date;

import com.google.gson.annotations.Expose;

import bd2.Muber.model.Driver;

public class DriverDTO {
	@Expose
	protected long id;
	@Expose
	protected String username;
	@Expose
	protected String pass;
	@Expose
	protected Date creationDate;
	@Expose
	private LicenseDTO license;
	@Expose
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
