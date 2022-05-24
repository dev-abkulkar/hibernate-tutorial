package org.telusko.firsttlevelcache;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "EMPLOYEE")
class Employee {
	
	@Id
	private String employeeId;
	
	private String name;

	public Employee() {
		super();
	}

	public Employee(String employeeId, String name) {
		super();
		this.employeeId = employeeId;
		this.name = name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
