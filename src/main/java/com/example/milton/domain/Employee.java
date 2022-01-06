package com.example.milton.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table (name= "employee")
public class Employee extends BaseEntity{
	 	private String firstName;
		private String lastName;
		private String dob;
		private String nid;
		private String email;
	    private String phoneNumber;
	    private String jobQualification;
	    private String orgName;


}
