package com.perficient.microservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.perficient.microservices.dao.ClientDAO;
import com.perficient.microservices.model.Client;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    
    @Autowired
    private ClientDAO clientDAO;

    @Override
    @PostMapping("/client/createUpdateClient")
    public Client createClient(Client client) {
        //logger.debug("createClient called");
        System.out.println("called client");
        return clientDAO.createClient(client);
    }
    

    @Override
    @PostMapping("/client/searchClient")
    public Client searchClient(Client client) {
        //logger.debug("createClient called");
        System.out.println("called client");
        return clientDAO.searchClient(client);
    }
}
