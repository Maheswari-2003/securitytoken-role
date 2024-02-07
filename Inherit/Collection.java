package com.example.Inherit;

import java.util.*;
import java.util.stream.Collectors;

public class Collection{
    public static void main(String[] args) {



        /*List<String> stringList = new ArrayList<>();

        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");

        System.out.println("List Elements: " + stringList);


        stringList.remove("Banana");
        stringList.add("Orange");


        System.out.println("List Elements after Deletion: " + stringList);

        Set<String> stringSet = new HashSet<>();

        stringSet.add("Red");
        stringSet.add("Green");
        stringSet.add("Blue");

        System.out.println("Set Elements: " + stringSet);

        stringSet.remove("Green");
        stringSet.add("Red");

        System.out.println("Set Elements after Deletion: " + stringSet);

        Queue<String> stringQueue = new LinkedList<>();  // Using LinkedList as Queue

        stringQueue.offer("One");
        stringQueue.offer("Two");
        stringQueue.offer("Three");

        System.out.println("Queue Elements: " + stringQueue);

        String dequeuedElement = stringQueue.poll();
        System.out.println("Dequeued Element: " + dequeuedElement);
        System.out.println("Queue Elements after Dequeue: " + stringQueue);*/


                Map<String, Integer> studentGrades = new HashMap<>();

                studentGrades.put("Mahes", 85);
                studentGrades.put("maha", 89);
                studentGrades.put("chitra", 75);
                studentGrades.put("swetha", 92);


                System.out.println(studentGrades.get("maha"));

                String studentName = "Mahes";
                if (studentGrades.containsKey(studentName)) {
                    System.out.println(studentGrades.get(studentName));
                } else {
                    System.out.println(studentName + " not found in the map.");
                }
                System.out.println("\nAll Students and Their Grades:");
                for (String student : studentGrades.keySet()) {
                    int grade = studentGrades.get(student);
                    System.out.println(student + ": " + grade);
                }
                studentGrades.put("maha", 80);
                System.out.println("Updated Grade for maha: " + studentGrades.get("maha"));

                String studentToRemove = "chitra";
                studentGrades.remove(studentToRemove);
                System.out.println("\n" + studentToRemove + " removed from the map.");

                System.out.println("\nNumber of Students in the Map: " + studentGrades.size());



        List<String> itemList = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            itemList.add("Item " + i);
        }
        System.out.println("Iterating through the list using forEach loop:");
        long startTime1 = System.currentTimeMillis();
        for (String item : itemList) {
            System.out.println(item);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("\nIterating through the list using Stream API:");
        long startTime2 = System.currentTimeMillis();
        itemList.stream().forEach(System.out::println);
        long endTime2 = System.currentTimeMillis();

       long loop=endTime1-startTime1;
       long stream=endTime2-startTime2;
       double secondsloop=(double)loop/1000.0;
       double secondsstream=(double)stream/1000.0;
        System.out.println(secondsloop);
        System.out.println(secondsstream);
       /* List<String> collectedList = itemList.stream().collect(Collectors.toList());

        System.out.println("\nCollected List using Stream API:");
        collectedList.forEach(System.out::println);*/

    }
}