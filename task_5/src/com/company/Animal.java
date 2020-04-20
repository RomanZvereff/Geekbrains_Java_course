package com.company;

public abstract class Animal {

    public abstract void run(int distance);

    public void swim(){
        System.out.println("Animal can't swim");
    };
    public abstract void swim(int distance);

    public abstract void jumpOver(double height);

}
