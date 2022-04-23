package org.telusko.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

	

	public Alien() {
		
	}
	
	public Alien(int aid, AlienName aname, String acolor) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.acolor = acolor;
	}

	@Id
	private int aid;
	
	
	private AlienName aname;
	
	private String acolor;
	
	
	public AlienName getAname() {
		return aname;
	}

	public void setAname(AlienName aname) {
		this.aname = aname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}


	public String getAcolor() {
		return acolor;
	}

	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}

	
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}

}
