package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.ClientException;
import com.masai.Exceptions.InsuaranceException;
import com.masai.Repository.ClientRepo;
import com.masai.Repository.InsuaranceRepo;
import com.masai.model.Client;
import com.masai.model.InsurancePolicy;

@Service
public class InsuaranceServiceImpl implements InsuranceService{

	

	@Autowired
	private InsuaranceRepo inRepo;

	@Override
	public InsurancePolicy createInsurance(InsurancePolicy in) {
		
		return inRepo.save(in);
	
	}

	@Override
	public List<InsurancePolicy> findAllInsurance() throws InsuaranceException {
		List<InsurancePolicy>list=inRepo.findAll();
		if(list.size()==0) throw new InsuaranceException("No Policy Found ");
		return list;
	}

	@Override
	public InsurancePolicy findById(Integer Id) throws InsuaranceException {
		 Optional<InsurancePolicy> opt	=inRepo.findById(Id);
		   if(!opt.isPresent()) throw new InsuaranceException("No Policy Exist with this id"+ Id);
		   
				return opt.get();
	}

	@Override
	public InsurancePolicy updateInsurance(Integer id, InsurancePolicy ip) throws InsuaranceException {
		Optional<InsurancePolicy> opt	=inRepo.findById(id);
		   if(!opt.isPresent()) throw new InsuaranceException("No policy Exist");
		   
		   else {
			   InsurancePolicy c= opt.get();
			  c.setAmount(ip.getAmount());
			  c.setEndDate(ip.getEndDate());
			  c.setStartDate(ip.getStartDate());
			   
			  InsurancePolicy updatedclient= inRepo.save(c);
			   return updatedclient;
		   }
	}

	@Override
	public String deletInsurance(Integer id) throws InsuaranceException {
		Optional<InsurancePolicy> opt	=inRepo.findById(id);
		   if(!opt.isPresent()) throw new InsuaranceException("No policy Exist with this id"+ id);
		   else {
			   inRepo.delete(opt.get()); 
			   return "Policy removed from system";
		   }
	}

	
	
}
