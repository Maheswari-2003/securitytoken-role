package com.example.Inherit;


public class Garbage {

    static class CustomObject {
        private int[] data;

        public CustomObject(int size) {
            this.data = new int[size];
        }


        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalizing CustomObject");
        }
    }

    public static void main(String[] args) {
        // Creating objects
        CustomObject obj1 = new CustomObject(1000000);
        CustomObject obj2 = new CustomObject(2000000);

        obj1 = null;
        obj2 = null;


        System.gc();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of program");
    }
}

