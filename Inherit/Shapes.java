package com.example.Inherit;

/*abstract class Shapes {
    public double area;
    public double perimeter;

    public Shapes() {
          System.out.println("hi");
    }

    public abstract void calculateArea();
    public abstract void calculatePerimeter();

    public void display() {
        System.out.println("Shape Information:");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Circles extends Shapes {
    private double radius;

    public Circles(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }
}

class Rectangles extends Shapes {
    private double length;
    private double width;

    public Rectangles(double length, double width) {
        super();
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        area = length * width;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }

    public static void main(String[] args) {
        Circles circle = new Circles(5.0);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.display();

        Rectangles rectangle = new Rectangles(4.0, 6.0);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        rectangle.display();
    }
}
*/
abstract class Shapes {
    protected double area;
    protected double perimeter;

    public Shapes() {
        System.out.println("Default constructor of Shapes");
    }

    public Shapes(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
        System.out.println("Parameterized constructor of Shapes");
    }

    public abstract void calculateArea();
    public abstract void calculatePerimeter();

    public void display() {
        System.out.println("Shape Information:");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Circles extends Shapes {
    private double radius;

    public Circles(double radius) {
        super(0.0,0.0);
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }
}

class Rectangles extends Shapes {
    private double length;
    private double width;

    public Rectangles(double length, double width) {

        super(0.0,0.0);
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        area = length * width;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }



    public static void main(String[] args) {
        Circles circle = new Circles(5.0);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.display();

        Rectangles rectangle = new Rectangles(4.0, 6.0);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
        rectangle.display();
    }
}
