package com.example.Inherit;


/*public interface MyInterface {

    void publicMethod();


    default void defaultMethod() {
        System.out.println("Default method calling privateMethod with privateVariable");
        int result = privateMethod(5);
        System.out.println("Result: " + result);
    }
    default void anotherDefaultMethod() {
        System.out.println("Another default method calling privateMethod with privateVariable");
        int result = privateMethod(10);
        System.out.println("Result: " + result);
    }


    private int privateMethod(int privateVariable) {
        System.out.println("Private method implementation using privateVariable");
        return privateVariable * 2;
    }
}


class MyClass implements MyInterface {
    @Override
    public void publicMethod() {
        System.out.println("Implementation of publicMethod");
    }



    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        myObject.publicMethod();

        myObject.defaultMethod();
        myObject.anotherDefaultMethod();
    }
}*/


public interface MyInterface {

    void publicMethod();

    default void defaultMethod() {
        System.out.println("Default method calling privateMethod with privateVariable");
        int result = privateMethod(5);
        System.out.println("Result: " + result);
    }

    default void anotherDefaultMethod() {
        System.out.println("Another default method calling privateMethod with privateVariable");
        int result = privateMethod(10);
        System.out.println("Result: " + result);
    }


    private static int privateMethod(int privateVariable) {
        System.out.println("Private static method implementation using privateVariable");
        return privateVariable * 2;
    }
}

class MyClass implements MyInterface {
    @Override
    public void publicMethod() {
        System.out.println("Implementation of publicMethod");
    }

    public static void main(String[] args) {
        MyClass myObject = new MyClass();

        myObject.publicMethod();

        myObject.defaultMethod();
        myObject.anotherDefaultMethod();
    }
}


