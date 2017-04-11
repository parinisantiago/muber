package model;

import java.sql.Date;

public class License {
	
	private Integer number;
	private Date expDate;
	
	public License() {
		super();
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Date getExpDate() {
		return expDate;
	}
	
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
}
