package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
