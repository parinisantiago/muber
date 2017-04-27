package bd2.Muber.model;

import java.util.Date;

public class License {
	
	public License(int number, Date expDate) {
		super();
		this.number = number;
		this.expDate = expDate;
	}

	private int number;
	private Date expDate;
	
	public License() {
		super();
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