package com.masai.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer claimNumber;
	
	@NotNull
	private String description;
	
	@NotNull
	private Date claimDate;
	
	@NotNull
	private String claimStatus;
	
	
	
	
}
