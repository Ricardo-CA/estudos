package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthdate;
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	public Client(String name, String email, Date birthdate) {
		super();
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String toString() {
		return name + " (" + sdf1.format(birthdate) + ") - " + email;
 	}

	
}
