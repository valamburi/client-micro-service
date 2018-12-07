package com.perficient.microservices.dao;

import com.perficient.microservices.model.Client;

public interface ClientDAO {

	Client findByCompany(String company);

	Client createClient(Client client);

	Client searchClient(Client client);

}
