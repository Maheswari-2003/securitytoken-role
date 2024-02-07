package com.example.Inherit.aop;


import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void performTask() {
        System.out.println("Task performed");
    }

    public void anotherTask() {

        System.out.println("Another task performed");
    }
}
