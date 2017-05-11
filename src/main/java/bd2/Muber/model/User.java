package bd2.Muber.model;

import java.util.Date;

import com.google.gson.annotations.Expose;

public abstract class User {
	
	@Expose
	protected Long oid;
	@Expose
	protected String username;
	@Expose
	protected String pass;
	@Expose
	protected Date creationDate;

	public User() {
		super();
	}

	public User(String username, String pass, Date creationDate) {
		super();
		this.username = username;
		this.pass = pass;
		this.creationDate = creationDate;
	}

	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
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

}