package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Address;

import java.util.List;

public interface AddressService {

       Address save(Address address);

       List<Address> findAll();


}
