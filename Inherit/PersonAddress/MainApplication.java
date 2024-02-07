package com.example.Inherit.PersonAddress;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.Inherit.PersonAddress.MainApplication.class, args);
    }
}
