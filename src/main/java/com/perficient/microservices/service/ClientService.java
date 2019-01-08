package com.perficient.microservices.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.perficient.microservices.model.Client;

public interface ClientService {
	@PostMapping("/client/createUpdateClient")
    Client createClient(Client client);
	
	@PostMapping("/client/searchClient")
    Client searchClient(Client client);
	
	List<Client> listAllClients();
}