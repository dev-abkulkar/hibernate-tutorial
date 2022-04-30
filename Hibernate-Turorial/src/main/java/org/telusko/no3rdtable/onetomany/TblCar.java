package org.telusko.no3rdtable.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "TBL_CAR")
class TblCar {

	@Id
	String registrationNumber;

	String color;

	@ManyToOne
	private TblCarOwner owner;
	
	public TblCar() {
		// TODO Auto-generated constructor stub
	}

	public TblCar(String registrationNumber, String color) {
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

	public TblCarOwner getOwner() {
		return owner;
	}

	public void setOwner(TblCarOwner owner) {
		this.owner = owner;
	}

}
