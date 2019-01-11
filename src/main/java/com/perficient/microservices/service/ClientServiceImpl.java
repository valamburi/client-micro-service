package com.perficient.microservices.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.perficient.microservices.dao.ClientDAO;
import com.perficient.microservices.model.Client;
import com.perficient.microservices.model.Error;
import com.perficient.microservices.model.Product;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientDAO clientDAO;

	@Override
	@PostMapping("/client/createUpdateClient")
	public Client createClient(Client client) {
		// logger.debug("createClient called");
		System.out.println("called client");
		return clientDAO.createClient(client);
	}

	@Override
	@PostMapping("/client/searchClient")
	public Client searchClient(Client client) {
		// logger.debug("createClient called");
		System.out.println("called client");
		return clientDAO.searchClient(client);
	}

	@Override
	public List<Client> listAllClients() {
		logger.debug("::listAllClients::");
		List<Client> clients = clientDAO.listClients();
		logger.debug("Clients: {}", clients);
		return clients;
	}

	@Override
	public Client updateClientWithProduct(String clientCompanyName, Product p) {

		logger.debug("::updateClientWithProduct::");
		// 1. get the client record
		// 2. Embed product within the client
		// 3. Save the client
		Client client = this.searchClient(clientCompanyName);

		if (null != client) {
			client.setProduct(p);
			client = clientDAO.createClient(client);
		} else {
			client = new Client();
			client.setCompany(clientCompanyName);
			Error e = new Error("NULL01", "Client not found!");
			client.setError(e);
		}

		return client;
	}

	@Override
	public Client searchClient(String client) {
		logger.debug("::searchClient:: Client: {}", client);
		return clientDAO.searchClient(client);
	}
}
