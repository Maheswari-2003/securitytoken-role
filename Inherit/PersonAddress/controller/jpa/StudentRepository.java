package com.example.Inherit.PersonAddress.controller.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<studententity, Long> {
    // Additional methods if needed...
}
