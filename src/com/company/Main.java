package com.company;

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Runnable shop = new Shop();
        Thread shop1 = new Thread(shop);
        shop1.start();
        int iterator = (int) (2 + Math.random() * 6);
        int name = 1;
        LocalTime start = LocalTime.now();
        while (true) {
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            if (duration.toSeconds() == iterator) {
                iterator += (int) (2 + Math.random() * 6);
                Runnable c = new Client(String.valueOf(name));
                Thread b = new Thread(c);
                b.start();
                name++;

            }
        }
    }
}
