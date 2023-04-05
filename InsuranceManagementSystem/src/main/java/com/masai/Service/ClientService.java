package com.masai.Service;

import java.util.List;
import com.masai.Exceptions.ClientException;
import com.masai.model.Client;

public interface ClientService {

	public Client createClient(Client client) ;
	
	public List<Client> findAllClient() throws ClientException;
	
	public Client findById(Integer Id) throws ClientException;
	
	public Client updateClient(Integer id,Client client) throws ClientException;
	
	public String deletClient(Integer id)throws ClientException;
	
	
	
}
