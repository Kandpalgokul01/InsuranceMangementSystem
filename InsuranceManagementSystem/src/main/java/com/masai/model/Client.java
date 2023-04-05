package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity

@Data

public class Client {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@NotNull
	private String Name;
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dob;
	
	private String Address;
	@Size(min = 10,max=10,message = "Please enter Only Correct Numbers")
	private String Contact;
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<InsurancePolicy> InsuarancPolicies=new ArrayList<>();
	
}
