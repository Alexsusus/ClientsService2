package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.PhoneService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.clientsservice.models.Client.Gender.FEMALE;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientAddressServiceDbTest {
    @Autowired
    private ClientService clientService;
    @Autowired
    private AddressService addressService;

    static Client a = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);

    static Address address = new Address(0L, "Region", "Dist", "City",
            "Street", "House", "Apartment", null);

    @Test
    @Order(1)
    void save() {

        a = clientService.save(a);
        address = addressService.save(address);
        a.setAddress(address);
        address.setClient(a);
        a = clientService.save(a);
        address = addressService.save(address);
    }

    @Test
    @Order(2)
    void findClientId() {
        Client actual = clientService.findById(a.getId());
        System.out.println(actual);
        System.out.println(actual.getAddress());
    }

}
