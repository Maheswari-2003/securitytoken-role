package com.example.Inherit;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Producer {
    public static void main(String[] args) {
        List<String> itemList = new ArrayList<>();
        Supplier<String> producer = () -> {
            String item = "Item-" + itemList.size();
            itemList.add(item);
            System.out.println("Produced: " + item);
            return item;
        };

        Consumer<String> consumer = item -> System.out.println("Consumed: " + item);

        for (int i = 0; i < 5; i++) {
            String producedItem = producer.get();
            consumer.accept(producedItem);
        }
    }
}
