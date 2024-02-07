package com.example.Inherit;


import java.io.*;   //nio
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class filehandle{
    public static void main(String[] args) {
        List<String> Names = new ArrayList<>();
        Names.add("Kumar");
        Names.add("Ramesh");
        Names.add("Priya");
        Names.add("Pooja");
        Names.add("Divya");
        Names.add("Anita");
        Names.add("Arjun");
        Names.add("Rajesh");
        Names.add("Suresh");
        Names.add("Siva");
        Names.add("Suresh");
        Names.add("Pooja");
        Names.add("Siva");
        Names.add("Anita");
        Names.add("Divya");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Hi i am maheswari\n");
            writer.write("from brimma tech\n");
            writer.write("Brimma tech Engineers\n");

//            Names.stream();

            for (String name: Names
            ) {
                writer.write(name+"\n");
            }
            writer.close();

        } catch (IOException f) {
            f.printStackTrace();     // line
        }//finally {                                    //???????
//                          writer.close();
//       }
        String Name;
        List<String> UniqueName = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            while ((Name = reader.readLine()) != null)
                System.out.println(Name);
            UniqueName.add(Name);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}