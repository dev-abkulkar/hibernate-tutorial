package org.telusko.eagerload;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="EAGER_OUTPUT_PORT")
class OutputPort {

	@Id
	private int portId;

	private String portName;
	
	
	@ManyToOne
	private Laptop laptop;

	public OutputPort() {
		super();
	}

	public OutputPort(int portId, String portName) {
		super();
		this.portId = portId;
		this.portName = portName;
	}

	public int getPortId() {
		return portId;
	}

	public void setPortId(int portId) {
		this.portId = portId;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

}
