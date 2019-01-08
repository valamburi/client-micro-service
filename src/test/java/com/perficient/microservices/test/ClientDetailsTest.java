package com.perficient.microservices.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.perficient.microservices.dao.ClientDAO;
import com.perficient.microservices.model.Address;
import com.perficient.microservices.model.Client;
import com.perficient.microservices.model.Client.ClientAction;
import com.perficient.microservices.model.Product;
import com.perficient.microservices.service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableMongoRepositories(basePackageClasses = ClientDAO.class)
public class ClientDetailsTest {
	
/*
	private static final String LOCALHOST = "cluster0-shard-00-00-pwcx3.mongodb.net";
    private static final String DB_NAME = "abctelecom";
    private static final int MONGO_TEST_PORT = 27017;*/
    @Autowired
    private ClientService repoImpl;




    @Test
    public void setUp() throws Exception {
        Client sample = new Client();
        sample.setCompany("Perficient");
        sample.setEmail("john@perficient.com");
        sample.setName("John");
        sample.setPhone("999-345-8907");
        sample.setAction(ClientAction.C);
        
        Product mockProduct = new Product();
        mockProduct.setName("Internet");
        mockProduct.setProductId("1001");
        sample.setProduct(mockProduct);
        
        Address address= new Address();
        address.setAddressLine1("100 N 6th St");
        address.setAddressLine2("Suite 550A");
        address.setCity("Minneapolis");
        address.setCountry("Hennepin");
        address.setState("Minnesota");
        address.setZipCode("55403");
        sample.setAddress(address);
       // this.repoImpl.createClient(sample);
        Client clientSaved = repoImpl.createClient(sample);
        Assert.assertEquals(clientSaved.getCompany(), sample.getCompany());
        

    }
}


