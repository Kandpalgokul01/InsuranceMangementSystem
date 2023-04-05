package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Client;

public interface ClientRepo  extends JpaRepository<Client,Integer>{

	
}
