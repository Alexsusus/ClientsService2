package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Account;

import java.util.List;
import java.util.Set;

public interface AccountService {
    Account save(Account account);


    List<Account> findAll();
}
