package com.example.Inherit.PersonAddress;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


   // @Query(nativeQuery=true,value="SELECT DISTINCT p.name FROM Person p JOIN p.addresses a WHERE a.city = :cityName")
   // List<String> findPersonNamesByCity(String cityName);
   List<Person> findByAddressesCity(String cityName);
}


