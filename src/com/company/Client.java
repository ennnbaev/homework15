package com.company;

public class Client implements Runnable {
    //переопределяю метод и вызываю в нем статический метод Shop.state();
    @Override
    public void run() {
        try {
            Shop.state();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
