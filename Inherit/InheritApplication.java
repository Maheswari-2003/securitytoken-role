package com.example.Inherit;

// Parent class
class Vehicle {
	String brand;

	//Constructor of the Vehicle class
	public Vehicle(String brand) {
		this.brand = brand;
		System.out.println("Vehicle constructor called. Brand: " + brand);
	}

	void displayInfo() {
		System.out.println("This is a vehicle of brand: " + brand);
	}
}

// Child class inheriting from Vehicle
class car extends Vehicle {
	int numOfWheels;

	// Constructor of the Car class
	public car(String brand, int numOfWheels) {
		super(brand); // Calling the constructor of the parent class using super keyword
		this.numOfWheels = numOfWheels;
		System.out.println("Car constructor called. Number of wheels: " + numOfWheels);
	}

	// Overriding the displayInfo method of the parent class
	@Override
	void displayInfo() {
		super.displayInfo(); // Calling the method of the parent class using super keyword
		System.out.println("This car has " + numOfWheels + " wheels.");
	}
}

// Main class to test the inheritance
class main {
	public static void main(String[] args) {
		car myCar = new car("Toyota", 4);
		myCar.displayInfo();
	}
}
