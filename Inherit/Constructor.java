package com.example.Inherit;

import org.yaml.snakeyaml.constructor.Construct;

public class Constructor {
    int id;
    String name;
    Constructor() {
        System.out.println("hello");

    }
    Constructor(int id){
        this.id=id;
    }
    Constructor(String name){
        this.name=name;
    }
    Constructor(int id,String name){
        this.id=id;
        this.name=name;
    }
    public void display(){
        System.out.println(id+name);
    }
    public static void main(String args[]){
       //Constructor one=new Constructor();
       Constructor two=new Constructor(6);
       //Constructor three=new Constructor("maheswari");
       //Constructor four=new Constructor(6,"maheswari");
       // one.display();
        two.display();
        //three.display();
        //four.display();
    }

}
