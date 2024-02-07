package com.example.Inherit;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Predicates{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("kayal", "maha", "chits", "anu", "Swetha", "mahes");

        Predicate<String> isNameLength = s -> s.length() <= 4;

        Function<String, String> convertToUppercase = String::toUpperCase;

        List<String> resultNames = names.stream()
                .filter(isNameLength)
                .map(convertToUppercase)
                .collect(Collectors.toList());

        System.out.println("Filtered and Uppercase Names: " + resultNames);
    }
}
