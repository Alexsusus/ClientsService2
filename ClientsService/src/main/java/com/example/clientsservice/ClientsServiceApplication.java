package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.repositories.PhoneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static com.example.clientsservice.models.Client.Gender.*;

@SpringBootApplication
public class ClientsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
    }

    private final ClientRepository clientRepository;

    public ClientsServiceApplication(ClientRepository clientRepository, PhoneRepository phoneRepository) {
        this.clientRepository = clientRepository;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        Client a = new Client(0, "a", "a", "a", MALE, "a@test.com",
                null, null, null);
        Client b = new Client(0, "b", "b", "b", MALE, "b@test.com",
                null, null, null);



        clientRepository.saveAll(List.of(a, b));
    }
}
