package com.example.Inherit;

import java.util.*;
import java.sql.*;

class JDBCconnectionApplication {

    private static final String url = "jdbc:postgresql://localhost:5432/Admission";
    private static final String user = "postgres";
    private static final String password = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            createTable(connection);
            //Thread.sleep(7000);
            while (true) {

                System.out.println("\nChoose an option:");
                System.out.println("1. Select");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Insert");
                System.out.println("5. Quit");

                int choice = getUserChoice();

                switch (choice) {
                    case 1:
                        executeSelectQuery(connection);
                        break;
                    case 2:
                        executeUpdateQuery(connection);
                        break;
                    case 3:
                        executeDeleteQuery(connection);
                        break;
                    case 4:
                        executeInsertQuery(connection);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private static void createTable(Connection connection) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS person_details ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(255),"
                + "age INT)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created successfully.");
        }
    }
    private static void executeSelectQuery(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM person_details";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        }
    }
    private static void executeUpdateQuery(Connection connection) throws SQLException {

        String updateQuery = "UPDATE person_details SET age = age + 1 WHERE id = 1";
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(updateQuery);
            System.out.println(rowsAffected + " row(s) updated.");
        }
    }
    private static void executeDeleteQuery(Connection connection) throws SQLException {

        String deleteQuery = "DELETE FROM person_details WHERE id = 2";
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(deleteQuery);
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }
    private static void executeInsertQuery(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO person_details (name, age) VALUES ('Shyam', 12)";
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(insertQuery);
            System.out.println(rowsAffected + " row(s) inserted.");
        }
    }
    private static int getUserChoice() {

        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            return choice;
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
        }
        return 0;
    }
}
