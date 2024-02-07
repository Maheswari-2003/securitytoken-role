package com.example.Inherit.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Mainapp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MyService myService = context.getBean(MyService.class);
        myService.performTask();
        myService.anotherTask();

        context.close();
    }
}
