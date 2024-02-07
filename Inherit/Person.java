package com.example.Inherit;

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int studentID;

    Student(String name,int age,int studentID) {
        super(name, age);
        this.studentID = studentID;
    }


    void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentID);
    }


    public static void main(String[] args) {
        Student obj = new Student("mahi",21,768);
        obj.displayInfo();
        String str="maheswari";
        String str1="ks";
        System.out.println(str.equals(str1));
        System.out.println(obj.hashCode());
    }
}

