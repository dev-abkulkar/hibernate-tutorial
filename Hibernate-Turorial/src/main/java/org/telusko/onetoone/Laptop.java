package org.telusko.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private int laptopId;
	
	private String description;	

	public Laptop(String description) {
		super();
		this.description = description;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", description=" + description + "]";
	}
	
	
	
}
