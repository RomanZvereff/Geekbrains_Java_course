package com.company;

import java.util.Random;

public class Cat extends Animal {

    String[] colors = {"white, black, grey, brown"};

    String name;
    int age;
    String color;
    String size;
    int appetite;
    int count;

    // Constructor
    public Cat(String name) {
        this.name = name;
        count++;
    }

    // Getters & Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if((age < 0) || (age > 20)) {
            System.out.println("Cats don't live that much");
        }else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        for (String item : colors) {
            if(item.equals(color)) {
                this.color = color;
            }else {
                System.out.println("Choose a color from the following options:");
                System.out.println("White, Black, Grey, Brown");
            }
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if(size.equals("small") || size.equals("middle") || size.equals("big")) {
            this.size = size;
        }else {
            System.out.println("Choose a size from the following options:");
            System.out.println("Small, Middle, Big");
        }
    }

    //Behaviors
    public boolean eatFood(Bowl bowl) {
        Random random = new Random();
        if (size.equals("small")) {
            appetite = random.nextInt(9 + 1) + 1;
        }else if(size.equals("middle")) {
            appetite = random.nextInt(9 + 1) + 11;
        }else {
            appetite = random.nextInt(9 + 1) + 22;
        }

        if(bowl.foodVolume - appetite >= 0) {
            bowl.foodVolume -= appetite;
            return true;
        }else {
            return false;
        }
    }

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
