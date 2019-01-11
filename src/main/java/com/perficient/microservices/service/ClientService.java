package com.perficient.microservices.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.perficient.microservices.model.Client;
import com.perficient.microservices.model.Product;

public interface ClientService {
	@PostMapping("/client/createUpdateClient")
    Client createClient(Client client);
	
	@PostMapping("/client/searchClient")
    Client searchClient(Client client);
	
	List<Client> listAllClients();
	
	Client updateClientWithProduct(String clientCompanyName, Product p);

	Client searchClient(String client);
}
