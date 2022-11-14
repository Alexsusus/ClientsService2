package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.example.clientsservice.models.Client.Gender.FEMALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAccountServiceDbTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;
    static Client a = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);
    static Account account = new Account(0L,100500,null);



    @Test
    @Order(1)
    void save(){
        a = clientService.save(a);
        Set<Client> clientSet = Set.of(a);
        account.setClients(clientSet);
        account = accountService.save(account);
    }


    @Test
    @Order(2)
    void findClientId(){
        Client actual = clientService.findById(a.getId());
        System.out.println(actual);
        System.out.println(actual.getAccounts());
    }
}


