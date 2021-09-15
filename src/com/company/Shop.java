package com.company;

import java.time.Duration;
import java.time.LocalDateTime;

public class Shop implements Runnable {
    static int counter = 0;
    static boolean state;
    static int iterator = 30;

    @Override
    public void run() {
        LocalDateTime start = LocalDateTime.now();
        while (true) {
            state = true;
            LocalDateTime end = LocalDateTime.now();
            Duration between = Duration.between(start, end);
            if (between.toSeconds() == iterator) {
                state = false;
                iterator += 15;
                counter = 0;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void state(Thread f) throws InterruptedException {
        if (state && counter < 5) {
            counter++;
            int counterClient = 0;
            System.out.println("Users " + f.getName());
            while (counterClient != 100) {
                if (state) {
                    Thread.sleep(((int) (1 + Math.random() *9))*10);
                    counterClient++;
                }
            }
            counter--;
        } else {
            System.out.println("В магазине нет места или он закрыт");
        }
    }
}
