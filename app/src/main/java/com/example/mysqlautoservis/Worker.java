package com.example.mysqlautoservis;

import java.util.ArrayList;

class Worker {
    String name;
    String skill;
    int age;

    public  ArrayList<Car> cars = new ArrayList<>();

    public Worker(String name, String skill, int age) {
        this.name = name;
        this.skill = skill;
        this.age = age;
    }


}
