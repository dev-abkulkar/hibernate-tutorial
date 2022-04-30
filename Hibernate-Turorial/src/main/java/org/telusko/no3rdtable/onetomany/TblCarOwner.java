package org.telusko.no3rdtable.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TBL_CAR_OWNER")
 class TblCarOwner {

	public TblCarOwner() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	private String ownerId;
	
	private String ownerName;
	
	@OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
	private List<TblCar> ownedCars = new ArrayList<>();

	public TblCarOwner(String ownerId, String ownerName, List<TblCar> ownedCars) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownedCars = ownedCars;
	}

	public TblCarOwner(String ownerId, String ownerName) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
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

	public List<TblCar> getOwnedCars() {
		return ownedCars;
	}

	public void setOwnedCars(List<TblCar> ownedCars) {
		this.ownedCars = ownedCars;
	}
	
	

}
