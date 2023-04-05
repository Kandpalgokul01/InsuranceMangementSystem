package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.InsuaranceException;
import com.masai.Service.InsuranceService;
import com.masai.model.InsurancePolicy;

@RestController
@RequestMapping("/policies/")
public class InsuaranceController {

	
	@Autowired
	private InsuranceService inService;
	
	@PostMapping("/")
	public ResponseEntity<InsurancePolicy> createPolicyHandler(@RequestBody InsurancePolicy ip){
		
		
		return new ResponseEntity<InsurancePolicy>(inService.createInsurance(ip), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/all/")
  public ResponseEntity<List<InsurancePolicy>> AllPoliciesHandler() throws InsuaranceException{
		List<InsurancePolicy> in=inService.findAllInsurance();
		
		return new ResponseEntity<List<InsurancePolicy>>(in, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<InsurancePolicy> onePoliciesHandler(@PathVariable("id") Integer id ) throws InsuaranceException{
			InsurancePolicy cl=inService.findById(id);
			
			return new ResponseEntity<InsurancePolicy>(cl, HttpStatus.OK);
			
			
		}
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<InsurancePolicy> updatePoliciesHandler(@RequestBody InsurancePolicy ip, @PathVariable Integer id ) throws InsuaranceException{
		InsurancePolicy cl=inService.updateInsurance(id, ip);
		
		
		return new ResponseEntity<InsurancePolicy>(cl, HttpStatus.ACCEPTED);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePoliciesHandler(@PathVariable Integer id ) throws InsuaranceException{
		String s=inService.deletInsurance(id);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
		
		
	}
		
		
	
	
}
