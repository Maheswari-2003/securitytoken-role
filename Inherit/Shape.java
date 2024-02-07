/*package com.example.Inherit;

abstract class Shape {

    public abstract double area();

    public void printArea() {
        System.out.println("Area: " + area());
    }


    public abstract double calculateArea();
}

// Concrete subclass
class Circles extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    public double area() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }



    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);

        circle.printArea();
        rectangle.printArea();
        String text = "Hello world ";

        int startIndex = 7;
        int codePointOffset = 2;
        int newIndex = text.offsetByCodePoints(startIndex, codePointOffset);
        System.out.println("Original String: " + text);
        System.out.println("Starting Index: " + startIndex);
        System.out.println("Code Point Offset: " + codePointOffset);
        System.out.println("New Index: " + newIndex);

        char characterAtIndex = text.charAt(newIndex);
        System.out.println("Character at the new index: " + characterAtIndex);
        //region matches
        String str1 = "Hello World!";
        String str2 = "World";

        boolean isMatch = str1.regionMatches(true, 6, str2, 0, 5);
        if (isMatch) {
            System.out.println("The specified region matches.");
        } else {
            System.out.println("The specified region does not match.");
        }


        //replacefirst
        String originalString = "Hi all welcome again Hi";
        System.out.println(originalString.replaceFirst("Hi", "hello"));



        //replaceall
        String t="i am maheswari and i am currently learning java";
        System.out.println( t.replaceAll("am", "welcome"));

        //split
        String sentence = "Hello this is a sample sentence split into words.";
        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
       //startswith
        String te = "The university is so big";
        boolean s = te.startsWith("The");
        boolean q = te.toLowerCase().startsWith("the");
        System.out.println(s);
        System.out.println(q);
        //subsequence
        System.out.println(te.subSequence(7,18));
        //substring
        System.out.println((te.substring(7,18)));
        System.out.println(te.trim());
        System.out.println(te);




    }
}
/*
 */


