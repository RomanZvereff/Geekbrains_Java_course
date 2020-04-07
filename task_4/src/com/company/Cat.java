package com.company;

public class Cat extends Animal {

    @Override
    public void run(int distance) {
        if((distance < 0) ||(distance > 200)) {
            System.out.println("run: false");
        }else {
            System.out.println("run: true");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can't swim!");
    }

    @Override
    public void jumpOver(double height) {
        if((height < 0) ||(height > 2)) {
            System.out.println("jump over: false");
        }else {
            System.out.println("jump over: true");
        }
    }
}
