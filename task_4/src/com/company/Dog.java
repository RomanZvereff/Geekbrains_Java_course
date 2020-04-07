package com.company;

public class Dog extends Animal {

    @Override
    public void run(int distance) {
        if((distance < 0) ||(distance > 500)) {
            System.out.println("run: false");
        }else {
            System.out.println("run: true");
        }
    }

    @Override
    public void swim(int distance) {
        if((distance < 0) ||(distance > 10)) {
            System.out.println("run: false");
        }else {
            System.out.println("run: true");
        }
    }

    @Override
    public void jumpOver(double height) {
        if((height < 0) ||(height > 0.5)) {
            System.out.println("jump over: false");
        }else {
            System.out.println("jump over: true");
        }
    }
}
