package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.ClientException;
import com.masai.Repository.ClientRepo;
import com.masai.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	private ClientRepo clientRepo;

	@Override
	public Client createClient(Client client) {
		
		clientRepo.save(client);
		return null;
	}

	@Override
	public List<Client> findAllClient() throws ClientException {
		List<Client>list=clientRepo.findAll();
		if(list.size()==0) throw new ClientException("No Client Found ");
		return list;
	}

	@Override
	public Client findById(Integer Id) throws ClientException {
   Optional<Client> opt	=clientRepo.findById(Id);
   if(!opt.isPresent()) throw new ClientException("No Client Exist with this id"+ Id);
   
		return opt.get();
	}

	@Override
	public Client updateClient(Integer id,Client client) throws ClientException {
		 Optional<Client> opt	=clientRepo.findById(id);
		   if(!opt.isPresent()) throw new ClientException("No Client Exist");
		   
		   else {
			  Client c= opt.get();
			   c.setName(client.getName());
			   c.setAddress(client.getAddress());
			   c.setContact(client.getContact());
			   c.setDob(client.getDob());
			  Client updatedclient= clientRepo.save(c);
			   return updatedclient;
		   }
		  
	}

	@Override
	public String deletClient(Integer id) throws ClientException {
		 Optional<Client> opt	=clientRepo.findById(id);
		   if(!opt.isPresent()) throw new ClientException("No Client Exist with this id"+ id);
		   else {
			   clientRepo.delete(opt.get()); 
			   return "Client removed from system";
		   }
		
	}
	
	
}
