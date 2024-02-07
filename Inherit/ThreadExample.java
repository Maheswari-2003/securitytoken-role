package com.example.Inherit;

import java.util.Random;

class ThreadExample {
    private int number1;
    private int number2;
    private int result;
    private boolean isDataReady = false;

    synchronized void produceData() {
        try {
            Thread.sleep(4000);

            Random random = new Random();
            number1 = random.nextInt(100);
            number2 = random.nextInt(100);


            isDataReady = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consumeData() {
        while (!isDataReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        result = number1 + number2;

        System.out.println("Adding: " + number1 + " + " + number2 + " = " + result);


        isDataReady = false;
    }
}

class Producers extends Thread {
    private ThreadExample te;

    Producers(ThreadExample te) {
        this.te = te;
    }

    @Override
    public void run() {
        te.produceData();
    }
}

class Consumer extends Thread {
    private ThreadExample te;

    Consumer(ThreadExample te) {
        this.te =te;
    }

    @Override
    public void run() {
        te.consumeData();
    }
}

 class CalculatorExample {
    public static void main(String[] args) {
        ThreadExample sharedResource = new ThreadExample();

        Producers producerThread = new Producers(sharedResource);
        Consumer consumerThread = new Consumer(sharedResource);

        producerThread.start();
        consumerThread.start();
    }
}

