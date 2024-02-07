package com.example.Inherit.bicyclebooking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Bookable {
    String getId();

    boolean isBooked();

    void book();

    void unbook();
}

class Bicycle implements Bookable {
    private final String id;
    private boolean booked;

    public Bicycle(String id) {
        this.id = id;
        this.booked = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isBooked() {
        return booked;
    }

    @Override
    public void book() {
        booked = true;
    }

    @Override
    public void unbook() {
        booked = false;
    }
}

interface BookingSystem {
    void addBookable(Bookable bookable);

    void book(String id);

    void unbook(String id);

    void displayBookables();
}

class BicycleBookingSystem implements BookingSystem {
    private final List<Bookable> bookables;
    private Connection connection;

    public BicycleBookingSystem() {
        this.bookables = new ArrayList<>();
        this.connection = initializeDatabase();
    }

    private Connection initializeDatabase() {
        try {

            Class.forName("org.postgresql.Driver");

            // Connect to the PostgreSQL database (replace "your_database_url", "your_username", and "your_password")
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

            // Create a table for bicycle booking information
            Statement stmt = conn.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS bookings (" +
                    "id TEXT PRIMARY KEY," +
                    "isBooked BOOLEAN)";
            stmt.execute(createTableQuery);

            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error initializing the database: " + e.getMessage());
        }
    }

    @Override
    public void addBookable(Bookable bookable) {
        bookables.add(bookable);
    }

    @Override
    public void book(String id) {
        Bookable bookable = getBookableById(id);
        if (bookable != null && !bookable.isBooked()) {
            bookable.book();
            storeBookingInfo(id, true);
            System.out.println("Bookable " + id + " booked successfully.");
        } else {
            System.out.println("Bookable " + id + " is not available for booking.");
        }
    }

    @Override
    public void unbook(String id) {
        Bookable bookable = getBookableById(id);
        if (bookable != null && bookable.isBooked()) {
            bookable.unbook();
            storeBookingInfo(id, false);
            System.out.println("Bookable " + id + " unbooked successfully.");
        } else {
            System.out.println("Bookable " + id + " is not currently booked.");
        }
    }

    @Override
    public void displayBookables() {
        System.out.println("Available Bookables:");
        for (Bookable bookable : bookables) {
            System.out.println("ID: " + bookable.getId() + ", Booked: " + bookable.isBooked());
        }
    }

    private Bookable getBookableById(String id) {
        for (Bookable bookable : bookables) {
            if (bookable.getId().equals(id)) {
                return bookable;
            }
        }
        return null;
    }

    private void storeBookingInfo(String id, boolean isBooked) {
        try {

            String insertUpdateQuery = "INSERT INTO bookings (id, isBooked) VALUES (?, ?) " +
                    "ON CONFLICT (id) DO UPDATE SET isBooked = EXCLUDED.isBooked";
            try (PreparedStatement pstmt = connection.prepareStatement(insertUpdateQuery)) {
                pstmt.setString(1, id);
                pstmt.setBoolean(2, isBooked);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error storing booking information: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BicycleBookingSystem();
        Scanner scanner = new Scanner(System.in);


        bookingSystem.addBookable(new Bicycle("B001"));
        bookingSystem.addBookable(new Bicycle("B002"));


        while (true) {
            System.out.println("Enter ID to book or unbook (type 'exit' to end):");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            if (userInput.startsWith("book ")) {
                bookingSystem.book(userInput.substring(5));
            } else if (userInput.startsWith("unbook ")) {
                bookingSystem.unbook(userInput.substring(7));
            }

            // Display the current status of bookables
            bookingSystem.displayBookables();
        }

        // Close the scanner and the database connection
        scanner.close();
        ((BicycleBookingSystem) bookingSystem).closeDatabaseConnection();
    }

    private void closeDatabaseConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing the database connection: " + e.getMessage());
        }
    }
}
