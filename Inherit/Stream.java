package com.example.Inherit;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> books = Arrays.asList(
                "Java Programming:2023:Maha",
                "Python Basics:2005:Maheswari,Chitra",
                "Web Development:2022:Siva,Swetha"
        );
        List<String> uppercaseTitles = books.stream()
                .map(book -> book.split(":")[0].toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Uppercase Titles: " + uppercaseTitles);

        List<String> recentBooks = books.stream()
                .filter(book -> Integer.parseInt(book.split(":")[1]) > 2000)
                .collect(Collectors.toList());

        System.out.println("Recent Books: " + recentBooks);

        List<String> allAuthors = books.stream()
                .flatMap(book -> Arrays.stream(book.split(":")[2].split(",")))
                .collect(Collectors.toList());

        System.out.println("All Authors: " + allAuthors);

        String s = "Mahalakshmi";
        boolean containsAuthor = allAuthors.contains(s);
        System.out.println(containsAuthor);

        long totalBooks = books.stream().count();
        System.out.println("Total number of books: " + totalBooks);
        String maxYearBook = books.stream()
                .max((book1, book2) ->
                        Integer.compare(Integer.parseInt(book1.split(":")[1]), Integer.parseInt(book2.split(":")[1])))
                .orElse(null);

        System.out.println("Book with Maximum Publication Year: " + maxYearBook);
        List<String> words = Arrays.asList("anu", "mahes", "maha", "chitra");
        List<String> uppercasedWords = words.stream()
                .peek(word -> System.out.println("Before Uppercase: " + word))
                .map(String::toUpperCase)
                .peek(word -> System.out.println("After Uppercase: " + word))
                .toList();
        System.out.println("Original List: " + words);
        System.out.println("Uppercased List: " + uppercasedWords);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);

        boolean anyGreaterThanFive = numbers.stream().anyMatch(n -> n > 5);


        System.out.println("Any even number? " + anyEven);
        System.out.println("Any number greater than 5? " + anyGreaterThanFive);
    }



}
