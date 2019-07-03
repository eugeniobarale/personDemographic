package com.persondemographic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	private String name;
	@Id
	private String ppsNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	private String mobilePhone;
	private Date creationDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPpsNumber() {
		return ppsNumber;
	}
	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	
	
}
