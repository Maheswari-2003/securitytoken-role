package com.example.Inherit.PersonAddress;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


   List<Person> findByAddressesCity(String cityName);
   List<Person> findByNameLike(String namePattern);
}


