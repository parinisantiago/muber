package bd2.Muber.dto;

import java.util.Date;

import com.google.gson.annotations.Expose;

import bd2.Muber.model.License;

public class LicenseDTO {
	@Expose
	private int number;
	@Expose
	private Date expDate;
	
	public LicenseDTO(License license){
		this.number = license.getNumber();
		this.expDate = license.getExpDate();
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
}
