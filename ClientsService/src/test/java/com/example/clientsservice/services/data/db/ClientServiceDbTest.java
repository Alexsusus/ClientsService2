package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Client;
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
public class ClientServiceDbTest {

    @Autowired
    private ClientService clientService;

    static Client a = new Client(0, "a", "a", "a", FEMALE,
            "a@test.com", null, null, null);
    static Client b = new Client(0, "b", "b", "b", MALE,
            "b@test.com", null, null, null);


    @Test
    @Order(1)
    void saveAll() {
        Client a_saved = clientService.save(a);
        Client b_saved = clientService.save(b);
        a.setId(a_saved.getId());
        b.setId(b_saved.getId());
        assertEquals(a, a_saved);
        assertEquals(b, b_saved);
    }

    @Test
    @Order(2)
    void findAllByCount() {
        assertEquals(2, clientService.findAll().size());
    }

    @Test
    @Order(3)
    void findAllByCollection() {
        List<Client> original = List.of(a, b);
        List<Client> saved = clientService.findAll();
        assertIterableEquals(original, saved);
    }

    @Test
    @Order(4)
    void findAllBySurnameNamePatronymic() {
        List<Client> actual =
                clientService.findAllBySurnameAndNameAndPatronymic(
                        a.getSurname(), a.getName(), a.getPatronymic());
        System.out.println(actual);
        assertEquals(a, actual.get(0));
    }

    @Test
    @Order(5)
    void deleteAll() {
        clientService.deleteAll();
        assertEquals(0, clientService.findAll().size());
    }

}
