
package com.example.devtools.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "Status", schema = "public")
public class Status {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int statusid;
	private String gender;
	private String Qualification;

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		this.Qualification = qualification;
	}

	@Override
	public String toString() {
		return "Status [statusid=" + statusid + ", gender=" + gender + ", Qualification=" + Qualification + "]";
	}

	public Status(int statusid, String gender, String qualification) {
		super();
		this.statusid = statusid;
		this.gender = gender;
		this.Qualification = qualification;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
