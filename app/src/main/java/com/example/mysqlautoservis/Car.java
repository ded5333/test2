package com.example.mysqlautoservis;

class Car {
    String markaModel;
    String crash;
    int priceCrash;
    long id = 0;

    public Car(String markaModel, String crash, int priceCrash) {
        this.markaModel = markaModel;
        this.crash = crash;
        this.priceCrash = priceCrash;
    }

}
