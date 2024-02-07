package com.example.Inherit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class ListSeparation {
    public static void main(String[] args) {
        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(new Item("Apple"));
        itemList1.add(new Item("Banana"));
        itemList1.add(new Item("Orange"));

        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Item("Grapes"));
        itemList2.add(new Item("Kiwi"));
        itemList2.add(new Item("Apple"));
        itemList2.add(new Item("Kiwi"));

        List<Item> sameList = new ArrayList<>();
        List<Item> leftoverList = new ArrayList<>();

        List<Item> commonElements = itemList1.stream()
                .filter(itemList2::contains)
                .collect(Collectors.toList());
        sameList.addAll(commonElements);


        List<Item> remainingElements = itemList2.stream()
                .filter(item -> !commonElements.contains(item))
                .collect(Collectors.toList());
        leftoverList.addAll(remainingElements);

        leftoverList.addAll(itemList1.stream()
                .filter(item -> !commonElements.contains(item))
                .collect(Collectors.toList()));

        System.out.println("Same List:");
        sameList.forEach(System.out::println);

        System.out.println("\nLeftover List:");
        leftoverList.forEach(System.out::println);
    }
}


