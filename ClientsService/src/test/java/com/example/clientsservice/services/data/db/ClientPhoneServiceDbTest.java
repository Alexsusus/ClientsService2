package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.PhoneService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientPhoneServiceDbTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PhoneService phoneService;
    static Client client = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);
    static Phone phone1 = new Phone(0,"111",null);
    static Phone phone2 = new Phone(0,"222",null);
    @Test
    @Order(1)
    void save(){
        client = clientService.save(client);
        phone1.setClient(client);
        phone2.setClient(client);
        //
        phone1 = phoneService.save(phone1);
        phone2 = phoneService.save(phone2);
    }

    @Test
    @Order(2)
    void findAll(){
        List<Phone> addresses = phoneService.findAll();
        System.out.println(addresses);
    }

    @Test
    @Order(3)
    void findAllByCollection() {
        List<Phone> original = List.of(phone1, phone2);
        List<Phone> saved = phoneService.findAll();
        assertIterableEquals(original, saved);
    }
    @Test
    @Order(4)
    void findClientId(){
        Client actual = clientService.findById(client.getId());
        System.out.println(actual);
        System.out.println(actual.getPhones());
    }
}
