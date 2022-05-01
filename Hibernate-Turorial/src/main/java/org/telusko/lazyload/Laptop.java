package org.telusko.lazyload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "LAZY_LAPTOP")
class Laptop {

	public Laptop() {
		
	}
	
	
	public Laptop(int laptopId, String modelName) {
		super();
		this.laptopId = laptopId;
		this.modelName = modelName;
	}


	@Id
	private int laptopId;
	
	private String modelName;
	
	@OneToMany(mappedBy = "laptop",cascade = CascadeType.ALL)
	private List<OutputPort> outputports = new ArrayList<>();

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<OutputPort> getOutputports() {
		return outputports;
	}

	public void setOutputports(List<OutputPort> outputports) {
		this.outputports = outputports;
	}
	
	
	public void addOutputPort(OutputPort outputPort) {
		outputPort.setLaptop(this);
		this.outputports.add(outputPort);
	}
	

}
