package com.masai.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyNumber;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	private Integer Amount;
	@Enumerated(EnumType.STRING)
	private Premium premium;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date startDate;
	
	@JsonFormat(pattern ="dd/MM/yyyy")
	private Date endDate;
	
	@ManyToOne
	@JsonIgnore
	private Client client;
	
	@OneToOne
	@JsonIgnore
	private Claim claim;
	
	
	
	
	
}
