package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.repositories.AddressRepository;
import com.example.clientsservice.repositories.PhoneRepository;
import com.example.clientsservice.services.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDb implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

}
