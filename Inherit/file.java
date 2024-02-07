package com.example.Inherit;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\maheswariks\\Downloads\\Maheswari.json";

        Studentsss jsonContent = readJsonAndConvertToJavaObject(filePath);

        if (jsonContent != null) {
            System.out.println("Java object:\n" + jsonContent.getAge());
        } else {
            System.out.println("Error reading JSON.");
        }
    }

    private static Studentsss readJsonAndConvertToJavaObject(String filePath) {
        try {

            File jsonFile = new File(filePath);

            Scanner scanner = new Scanner(jsonFile);

            StringBuilder jsonContentBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonContentBuilder.append(scanner.nextLine());
            }
            scanner.close();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonContentBuilder.toString(), Studentsss.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

