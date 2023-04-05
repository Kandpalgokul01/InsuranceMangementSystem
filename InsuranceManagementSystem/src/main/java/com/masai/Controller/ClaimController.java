
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

import com.masai.Exceptions.ClaimException;
import com.masai.Service.ClaimService;
import com.masai.model.Claim;

@RestController
@RequestMapping("/claim/")
public class ClaimController {

	@Autowired
	private ClaimService cService;
	
	@PostMapping("/")
	public ResponseEntity<Claim> createClaimHandler(@RequestBody Claim cl){
		
		
		return new ResponseEntity<Claim>(cService.createClaim(cl), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/all/")
  public ResponseEntity<List<Claim>> AllClaimHandler() throws ClaimException{
		List<Claim> cl=cService.findAllClaim();
		
		return new ResponseEntity<List<Claim>>(cl, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<Claim> oneClaimHandler(@PathVariable("id") Integer id ) throws ClaimException{
			Claim cl=cService.findById(id);
			
			return new ResponseEntity<Claim>(cl, HttpStatus.OK);
			
			
		}
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<Claim> updateClaimHandler(@RequestBody Claim claim, @PathVariable Integer id ) throws ClaimException{
		Claim cl=cService.updateClaim(id, claim);
		
		
		return new ResponseEntity<Claim>(cl, HttpStatus.ACCEPTED);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClaimHandler(@PathVariable Integer id ) throws ClaimException{
		String s=cService.deletClaim(id);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
		
		
	}
		
		
	
	
}
