package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Claim;

public interface ClaimRepo extends JpaRepository<Claim, Integer>{

}
