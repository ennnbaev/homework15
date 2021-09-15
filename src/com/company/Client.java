package com.company;

public class Client implements Runnable {
    Thread trd;

    Client(String name) {
        trd = new Thread(name);
        trd.start();
    }

    @Override
    public void run() {
        try {
            Shop.state(trd);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
