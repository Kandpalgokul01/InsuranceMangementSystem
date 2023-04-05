package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.ClaimException;
import com.masai.model.Claim;
import com.masai.model.Client;

public interface ClaimService {
 
	public Claim createClaim(Claim claim);

	public List<Claim> findAllClaim() throws ClaimException;
	
	public Claim findById(Integer Id) throws ClaimException;
	
	public Claim updateClaim(Integer id,Claim cl) throws ClaimException;
	
	public String deletClaim(Integer id)throws ClaimException;
	
	
	
	
}
