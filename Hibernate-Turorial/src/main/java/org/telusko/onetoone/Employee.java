package org.telusko.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private int empId;
	
	private String name;
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Laptop laptop;

	public Employee(String name, int age, Laptop laptop) {
		super();
		this.name = name;
		this.age = age;
		this.laptop = laptop;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", laptop=" + laptop + "]";
	}
		
}
