package com.perficient.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.perficient.microservices.model.Client;

@FeignClient
public interface ClientService {
	@PostMapping("/client/createUpdateClient")
    Client createClient(Client client);
	
	@PostMapping("/client/searchClient")
    Client searchClient(Client client);
}
