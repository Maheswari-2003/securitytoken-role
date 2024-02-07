package com.example.Inherit;


import java.util.Objects;

class Students {
    String name;
    int age;
    String address; // New field

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students student)) return false;
        return getAge() == student.getAge() &&
                getName().equals(student.getName()) ||
                getAddress().equals(student.getAddress()); // Include address in the comparison
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getAddress()); // Include address in the hash code calculation
    }



    public static void main(String[] args) {
        Students obj = new Students();
        obj.setName("maha");
        obj.setAge(18);
        obj.setAddress("123 Main St");

        Students obj1 = new Students();
        obj1.setName("maheswari");
        obj1.setAge(20);
        obj1.setAddress("456 anna street");

        System.out.println(obj.getName());
        System.out.println(obj.getAge());
        System.out.println(obj.getAddress());

        System.out.println(obj1.getName());
        System.out.println(obj1.getAge());
        System.out.println(obj1.getAddress());

        System.out.println(obj.equals(obj1));
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());
    }
}
