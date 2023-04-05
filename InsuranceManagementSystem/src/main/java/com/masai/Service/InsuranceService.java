package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.InsuaranceException;
import com.masai.model.InsurancePolicy;

public interface InsuranceService {
	
   public InsurancePolicy createInsurance(InsurancePolicy ip) ;
	
	public List<InsurancePolicy> findAllInsurance() throws InsuaranceException;
	
	public InsurancePolicy findById(Integer Id) throws InsuaranceException;
	
	public InsurancePolicy updateInsurance(Integer id,InsurancePolicy ip) throws InsuaranceException;
	
	public String deletInsurance(Integer id)throws InsuaranceException;
	
}
