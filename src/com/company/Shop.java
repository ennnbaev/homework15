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
                System.out.println("Начало перерыва в магазине");
                state = false;
                iterator += iterator+10;
                counter = 0;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Перерыв закончен");
            }
        }
    }

    //сначала проверяю открыт ли магазин и сколько в нем клиентов
    static void state() throws InterruptedException {
        if (state && counter < 5) {
            counter++;
            // далее через определенный отрезок времени постоянно проверяю состояние магазина и поток засыпает
            int counterClient = 0;
            int maxTime = 100;
            int time = ((int) (1 + Math.random() * 9) * 10);
            System.out.println("Посититель зашел в магазин");
            while (true) {
                if (state) {
                    Thread.sleep(time);
                    counterClient++;
                } else {
                    System.out.println("Посититель вышел так-как перерыв");
                    counter--;
                    break;
                }
                if (counterClient == maxTime) {
                    System.out.println("Посититель вышел из магазина");
                    counter--;
                    break;
                }
            }

        } else {
            System.out.println("В магазине нет места или он закрыт");
        }
    }
}
