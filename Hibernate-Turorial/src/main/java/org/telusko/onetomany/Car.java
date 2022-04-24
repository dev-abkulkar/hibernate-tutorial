package org.telusko.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	String registrationNumber;

	String color;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String registrationNumber, String color) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
