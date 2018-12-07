package com.perficient.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.perficient.microservices.model.Client;
import com.perficient.microservices.service.ClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

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

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/createUpdateClient", produces = "application/json")

	@HystrixCommand(fallbackMethod = "defaultCreateClient")
	@ApiOperation(value = "Create Client", notes = "Create Client")
	public Client createClient(@RequestBody Client client) {
		System.out.println("client-micro-service: Entering createClient");
		Client clientDetails = clientService.createClient(client);
		System.out.println("client-micro-service: Exiting createClient");
		return clientDetails;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/searchClient", produces = "application/json")
	@HystrixCommand(fallbackMethod = "defaultSearchClient")
	@ApiOperation(value = "Search Client", notes = "Search Client")
	public Client searchClient(@RequestBody Client client) {
		System.out.println("Inside SearchClient Controller");
		Client clientDetails = clientService.searchClient(client);
		return clientDetails;
	}
}
