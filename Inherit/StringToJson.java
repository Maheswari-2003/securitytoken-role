package com.example.Inherit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class StringToJson {
    public static void main(String[] args) throws Exception {

        String inputString = "{\"name\": \"Maheswari\", \"age\": 20, \"city\": \"Tvl\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(inputString);
        //objectMapper.convertValue()

        String outputPath = "C:\\Users\\maheswariks\\Downloads\\output.json";

        objectMapper.writeValue(new File(outputPath), jsonNode);

        System.out.println("JSON written to: " + outputPath);
    }
}
