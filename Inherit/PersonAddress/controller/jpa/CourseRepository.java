package com.example.Inherit.PersonAddress.controller.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<courseentity, Long> {
    // Additional methods if needed...
}
