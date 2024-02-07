package com.example.Inherit;


import java.util.Scanner;

 class AreaCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();

        double rectangleArea = findRectangleArea(length, width);
        System.out.println("Area of Rectangle: " + rectangleArea);

        try {
            System.out.print("Enter the radius of the circle: ");
            int radius = scanner.nextInt();
            double circleArea = findCircleArea(radius);
            System.out.println("Area of Circle: " + circleArea);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Enter the base of the triangle: ");
        int base = scanner.nextInt();
        System.out.print("Enter the height of the triangle: ");
        int height = scanner.nextInt();
        double triangleArea = findTriangleArea(base, height);
        System.out.println("Area of Triangle: " + triangleArea);


        System.out.print("Enter the side length of the square: ");
        int side = scanner.nextInt();
        double squareArea = findSquareArea(side);
        System.out.println("Area of Square: " + squareArea);
    }


    private static double findRectangleArea(int length, int width) {
        return length * width;
    }


    private static double findCircleArea(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        return Math.PI * radius * radius;
    }


    private static double findTriangleArea(int base, int height) {
        return 0.5 * base * height;
    }


    private static double findSquareArea(int side) {
        return side * side;
    }
}
