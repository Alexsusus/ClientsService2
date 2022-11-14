package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.clientsservice.models.Client.Gender.FEMALE;
import static com.example.clientsservice.models.Client.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAddressServiceDbTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AddressService addressService;

    static Client client = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);
    static Client client2 = new Client(0, "b", "b", "b", MALE,
            "b@test.com2", null, null, null);

    static Address address = new Address(0L, "Region", "Dist", "City",
            "Street", "House", "Apartment", null);
    static Address address2 = new Address(0L, "Region2", "Dist2", "City2",
            "Street2", "House2", "Apartment2", null);

    @Test
    @Order(1)
    void save() {

        client = clientService.save(client);
        address = addressService.save(address);
        client.setAddress(address);
        address.setClient(client);
        client = clientService.save(client);
        address = addressService.save(address);
        //
        client2 = clientService.save(client2);
        address2 = addressService.save(address2);
        client2.setAddress(address2);
        address2.setClient(client2);
        client2 = clientService.save(client2);
        address2 = addressService.save(address2);
    }

    @Test
    @Order(2)
    void findAll(){
        List<Address> addresses = addressService.findAll();
        System.out.println(addresses);
    }
    @Test
    @Order(3)
    void findAllByCollection() {
        List<Address> original = List.of(address,address2);
        List<Address> saved = addressService.findAll();
        assertIterableEquals(original, saved);
    }

    @Test
    @Order(4)
    void findClientId(){
        Client actual = clientService.findById(client.getId());
        System.out.println(actual);
        System.out.println(actual.getAddress());
    }
}
