package com.perficient.microservices.dao;

import java.util.List;

import com.perficient.microservices.model.Client;

public interface ClientDAO {

	Client findByCompany(String company);

	Client createClient(Client client);

	Client searchClient(Client client);
	
	List<Client> listClients();

	Client searchClient(String client);

}
