package com.example.Inherit.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ComplexCalculationService {

    @Scheduled(cron = "*/20 * * * * *")
    public void performComplexCalculation() {

        int number = generateRandomNumber();
        try {
            long result = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error calculating factorial: " + e.getMessage());
        }
    }

    private int generateRandomNumber() {

        return new Random().nextInt(21) - 10;
    }

    private long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}
