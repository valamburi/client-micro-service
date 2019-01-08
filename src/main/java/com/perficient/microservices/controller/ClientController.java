package com.perficient.microservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.perficient.microservices.model.Client;
import com.perficient.microservices.service.ClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;

	@SuppressWarnings("unused")
	private Client defaultCreateClient(@RequestBody Client client) {
		return client;
	}
	
	@SuppressWarnings("unused")
	private Client defaultSearchClient(@RequestBody Client client) {
		return client;
	}

	@PostMapping(value = "/createUpdateClient", produces = "application/json")

	@HystrixCommand(fallbackMethod = "defaultCreateClient")
	@ApiOperation(value = "Create Client", notes = "Create Client")
	public Client createClient(@RequestBody Client client) {
		System.out.println("client-micro-service: Entering createClient");
		Client clientDetails = clientService.createClient(client);
		System.out.println("client-micro-service: Exiting createClient");
		return clientDetails;
	}
	
	@PostMapping(value = "/searchClient", produces = "application/json")
	@HystrixCommand(fallbackMethod = "defaultSearchClient")
	@ApiOperation(value = "Search Client", notes = "Search Client")
	public Client searchClient(@RequestBody Client client) {
		System.out.println("Inside SearchClient Controller");
		Client clientDetails = clientService.searchClient(client);
		return clientDetails;
	}
	
	@RequestMapping(path = "/list", produces = "application/json", method = RequestMethod.GET)
	@ApiOperation(value = "List all Clients", notes = "List Clients registered to this portal")
	public List<Client> listAllClients() {

		logger.info("::listAllClients::");
		List<Client> clients = clientService.listAllClients();
		return clients;
	}
}
