package com.example.Inherit;


import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Date{
    public static void main(String args[]) {

        LocalDate dt=LocalDate.now();
        System.out.println(dt);
        LocalTime tt=LocalTime.now();
        System.out.println(tt);
        LocalDateTime dts=LocalDateTime.now();
        System.out.println(dts);
        DateTimeFormatter change=DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
        String changefinal=dts.format(change);
        System.out.println(changefinal);

        ZoneId londonZone = ZoneId.of("Europe/London");
        ZonedDateTime londonTime = ZonedDateTime.now(londonZone);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        System.out.println("ZoneId: " + londonZone);
        System.out.println("Current Time in London: " + londonTime.format(formatter));
    }
}