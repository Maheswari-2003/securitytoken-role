package com.example.Inherit.PersonAddress;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // Define custom queries if needed
}