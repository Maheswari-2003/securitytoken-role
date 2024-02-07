package com.example.Inherit;

interface AreaCalculate {
    double calculateArea();
}


class CircleImpl implements AreaCalculate {
    private double radius;

    public CircleImpl(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectangleImpl implements AreaCalculate {
    private double width;
    private double height;

    public RectangleImpl(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }



    public static void main(String[] args) {
        AreaCalculate circle = new CircleImpl(5.0);
        AreaCalculate  rectangle = new RectangleImpl(4.0, 6.0);

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
    }
}
