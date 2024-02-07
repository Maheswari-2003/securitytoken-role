package com.example.Inherit;


class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
            try {
                Thread.sleep(100); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class thread {
    public static void main(String args[]) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.setPriority(1);
        t2.setPriority(2);
        // Start the first thread
       // Start the second thread

        t2.start();
        t1.start();
    }
}
