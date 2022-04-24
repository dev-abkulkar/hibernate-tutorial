package org.telusko.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CarOwner {

	public CarOwner() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private String ownerId;
	
	private String ownerName;
	
	@OneToMany(cascade = CascadeType.ALL )
	private List<Car> ownedCars;

	public CarOwner(String ownerId, String ownerName, List<Car> ownedCars) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownedCars = ownedCars;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Car> getOwnedCars() {
		return ownedCars;
	}

	public void setOwnedCars(List<Car> ownedCars) {
		this.ownedCars = ownedCars;
	}
	
	

}
