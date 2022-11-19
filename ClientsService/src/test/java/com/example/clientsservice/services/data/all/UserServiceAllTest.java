package com.example.clientsservice.services.data.all;

import com.example.clientsservice.services.data.UserService;
import com.example.clientsservice.services.data.qualifiers.UserServiceQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserServiceAllTest {

    @UserServiceQualifier
    @Autowired
   private UserService userService;

    @Test
    public void autowired(){
        System.err.println(userService);
        Assertions.assertNotNull(userService);
    }
}
