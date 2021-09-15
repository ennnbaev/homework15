package com.company;

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Runnable shop = new Shop();
        Thread shop1 = new Thread(shop);
        shop1.start();
        int iterator = (int) (2 + Math.random() * 6);
        LocalTime start = LocalTime.now();
        //с помощью duration запускаю нового поситителя 1 раз в 2-5 секунд в магазин
        while (true) {
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            if (duration.toSeconds() == iterator) {
                iterator += (int) (2 + Math.random() * 6);
                Runnable c = new Client();
                Thread b = new Thread(c);
                b.start();
            }
        }
    }
}
