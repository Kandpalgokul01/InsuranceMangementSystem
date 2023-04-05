package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.ClaimException;
import com.masai.Exceptions.ClientException;
import com.masai.Repository.ClaimRepo;
import com.masai.model.Claim;
import com.masai.model.Client;
@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	private ClaimRepo cRepo;

	@Override
	public Claim createClaim(Claim claim) {
		      return  cRepo.save(claim);
		
	}

	@Override
	public List<Claim> findAllClaim() throws ClaimException {
		List<Claim>list=cRepo.findAll();
		if(list.size()==0) throw new ClaimException("No Claim Found ");
		return list;
	}

	@Override
	public Claim findById(Integer Id) throws ClaimException {
		 Optional<Claim> opt	=cRepo.findById(Id);
		   if(!opt.isPresent()) throw new ClaimException("No Claim Exist with this id"+ Id);
		   
				return opt.get();
	}

	@Override
	public Claim updateClaim(Integer id, Claim cl) throws ClaimException {
		 Optional<Claim> opt	=cRepo.findById(id);
		   if(!opt.isPresent()) throw new ClaimException("No Claim Exist");
		   
		   else {
			  Claim c= opt.get();
			 c.setClaimDate(cl.getClaimDate());
			 c.setClaimStatus(cl.getClaimStatus());
			 c.setDescription(cl.getDescription());
			  Claim updatedclaim= cRepo.save(c);
			  
			   return updatedclaim;
		   }
	}

	@Override
	public String deletClaim(Integer id) throws ClaimException {
		Optional<Claim> opt	=cRepo.findById(id);
		   if(!opt.isPresent()) throw new ClaimException("No Claim Exist with this id"+ id);
		   else {
			   cRepo.delete(opt.get()); 
			   return "Claim removed from system";
		   }
	}
	
	
	
	
}
