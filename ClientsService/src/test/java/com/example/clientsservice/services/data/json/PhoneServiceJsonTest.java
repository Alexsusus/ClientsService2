
package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.PhoneService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhoneServiceJsonTest {

    @Qualifier("phoneServiceJson")
    @Autowired
    private PhoneService phoneService;

    static Phone phone = new Phone(0,"111",null);

    @Test
    @Order(1)
    void save(){
        Phone actual = phoneService.save(phone);
        phone.setId(actual.getId());
        Assertions.assertEquals(phone,actual);
        System.err.println(phoneService.findAll());
    }
}

