package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.InsurancePolicy;

public interface InsuaranceRepo extends JpaRepository<InsurancePolicy, Integer> {

	
}

