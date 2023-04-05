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

import com.masai.Exceptions.ClientException;
import com.masai.Service.ClientService;
import com.masai.model.Client;

@RestController
@RequestMapping("/clients/")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping("/")
	public ResponseEntity<Client> createClientHandler(@RequestBody Client client){
		
		
		return new ResponseEntity<Client>(clientService.createClient(client), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/all/")
  public ResponseEntity<List<Client>> AllClientHandler() throws ClientException{
		List<Client> cl=clientService.findAllClient();
		
		return new ResponseEntity<List<Client>>(cl, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<Client> oneClientHandler(@PathVariable("id") Integer id ) throws ClientException{
			Client cl=clientService.findById(id);
			
			return new ResponseEntity<Client>(cl, HttpStatus.OK);
			
			
		}
	
	@PutMapping("/update/{id}")
	 public ResponseEntity<Client> updateClientHandler(@RequestBody Client client, @PathVariable Integer id ) throws ClientException{
		Client cl=clientService.updateClient(id, client);
		
		
		return new ResponseEntity<Client>(cl, HttpStatus.ACCEPTED);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteClientHandler(@PathVariable Integer id ) throws ClientException{
		String s=clientService.deletClient(id);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
		
		
	}
		
		
	
	
}
