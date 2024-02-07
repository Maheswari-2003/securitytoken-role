package com.example.Inherit;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Execute {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> System.out.println("Task 1 executed."));
        executor.execute(() -> System.out.println("Task 2 executed."));
        executor.execute(() -> System.out.println("Task 3 executed."));


        if (executor instanceof java.util.concurrent.ExecutorService) {
            ((java.util.concurrent.ExecutorService) executor).shutdown();
        }
    }
}

