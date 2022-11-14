package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAccountServiceDbTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;
    static Client client = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);
    static Client client2 = new Client(0, "b", "b", "b", MALE,
            "b@test.com2", null, null, null);
    static Account account = new Account(0L, 100500, null);
    static Account account2 = new Account(0L, 555, null);

    @Test
    @Order(1)
    void save() {
        client = clientService.save(client);
        client2 = clientService.save(client2);
        account = accountService.save(account);
        account2 = accountService.save(account2);

        account2.setClients(Set.of(client2));
        client.setAccounts(Set.of(account));
        client2.setAccounts(Set.of(account,account2));
        account.setClients(Set.of(client, client2));

        client = clientService.save(client);
        client2 = clientService.save(client2);

    }

    @Test
    @Order(2)
    void findAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    @Order(3)
    void findAllClients() {
        List<Client> clients = clientService.findAll();
        System.out.println(clients);
    }


    @Test
    @Order(4)
    void findAllByCollection() {
        List<Account> original = List.of(account,account2);
        List<Account> saved = accountService.findAll();
        assertIterableEquals(original, saved);
    }

    @Test
    @Order(5)
    void findAllByCollectionClients() {
        List<Client> original = List.of(client,client2);
        List<Client> saved = clientService.findAll();
        assertIterableEquals(original, saved);
    }

    @Test
    @Order(6)
    void findAccountId(){
        Client actual = clientService.findById(client2.getId());
        System.out.println(actual);
        System.out.println(actual.getAccounts());
    }

}




