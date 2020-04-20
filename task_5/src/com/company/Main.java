package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static ArrayList<Cat> cats = new ArrayList<>(5);
    static Random random = new Random();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello friend! Let's create four cats!");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter the " + i +  " cat's name: ");
            try {
                Cat cat = new Cat(reader.readLine());
                cats.add(cat);
                cat.age = random.nextInt(21);
                int randomSizeIndex = random.nextInt(3);
                if(randomSizeIndex == 0) {
                    cat.size = "small";
                }else if(randomSizeIndex == 1) {
                    cat.size = "middle";
                }else {
                    cat.size = "big";
                }
            } catch (IOException e) {
                System.out.println("Oops!" + e.getMessage());
            }
        }

        System.out.println("Now let's feed the cats and fill the bowl with food");
        System.out.println("Set maximum bowl capacity (from 10 to 100 units)");
        Bowl bowl = new Bowl();
        try {
            int bowlCapacity, foodValue;
            do {
                bowlCapacity = Integer.parseInt(reader.readLine());
            } while (bowl.setFullCapacity(bowlCapacity));
            System.out.println("Now fill the bowl (from 10 to " + bowlCapacity + " units)");
            do {
                foodValue = Integer.parseInt(reader.readLine());
            } while (bowl.setFoodVolume(foodValue));


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Let's try to feed cats");
        int count = 0;
        for (Cat cat : cats) {
            if(cat.eatFood(bowl)) {
                count++;
                System.out.println("Cat has eaten! it's happy!");
            }else {
                System.out.println("Cat still hungry!");
            }
            bowl.checkBowl();
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
