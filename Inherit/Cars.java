package com.example.Inherit;

public class Cars {
    private String make;
    private String model;
    private int year;
    public Cars() {
        make = "Unknown";
        model = "Unknown";
        year = 0;
    }

    public Cars(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Constructor with make and model parameters (default year is 0)
    public Cars(String make, String model) {
        this(make, model, 0); // Calls the parameterized constructor with default year
    }

    // Method to set car details
    public void setDetails(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public void setDetails(String make, String model) {
        setDetails(make, model, 0);
    }
    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public static void main(String[] args) {
        Cars car1 = new Cars("Toyota", "Camry", 2022);
        car1.displayDetails();

        Cars car2 = new Cars("Ford", "Focus");
        car2.displayDetails();
    }
}
