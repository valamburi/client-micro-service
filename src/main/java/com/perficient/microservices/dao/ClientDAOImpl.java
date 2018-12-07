package com.perficient.microservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.perficient.microservices.model.Client;
import com.perficient.microservices.model.Client.ClientAction;
import com.perficient.microservices.model.Client.ClientStatus;

@Repository("clientDAO")
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public Client findByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		System.out.println("Inside createClient : " + client);

		Query query = new Query();
		query.addCriteria(Criteria.where("company").is(client.getCompany()));

		Update update = new Update();
		update.set("address", client.getAddress());
		update.set("email", client.getEmail());
		update.set("name", client.getName());
		update.set("phone", client.getPhone());
		update.set("product", client.getProduct());
		ClientAction action = client.getAction();
		update.set("action", action);
		ClientStatus status = client.getStatus();
		update.set("status", status);
		// update.set("action", client.getAction());

		mongoOperation.upsert(query, update, Client.class);

		Client retrievedClient = mongoOperation.findOne(query, Client.class);
		System.out.println("retrievedClient" + retrievedClient);
		return retrievedClient;
	}

	@Override
	public Client searchClient(Client client) {
		// TODO Auto-generated method stub

		Query query = new Query();
		query.addCriteria(Criteria.where("company").is(client.getCompany()));

		Client retrievedClient = mongoOperation.findOne(query, Client.class);
		System.out.println("retrievedClient" + retrievedClient);
		return retrievedClient;
	}
}
