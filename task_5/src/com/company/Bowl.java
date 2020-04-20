package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bowl {

    int fullCapacity;
    int foodVolume;

    protected Bowl() {
    }

    public int getFullCapacity() {
        return fullCapacity;
    }

    protected boolean setFullCapacity(int fullCapacity) {
        if(fullCapacity >= 10 && fullCapacity <= 100) {
            this.fullCapacity = fullCapacity;
            System.out.println("Ok!");
            return false;
        }else {
            System.out.println("Try again!");
            return true;
        }
    }

    public int getFoodVolume() {
        return foodVolume;
    }

    protected boolean setFoodVolume(int foodVolume) {
        if((foodVolume < 10) || (foodVolume > fullCapacity)) {
            System.out.println("The food volume isn't fit in a bowl. Min capacity = 10, max capacity = " + fullCapacity);
            return true;
        }else {
            this.foodVolume = foodVolume;
            System.out.println("Ok");
            return false;
        }
    }

    protected boolean checkBowl() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = true;
        if(foodVolume == 0) {
            System.out.println("Fill a bowl (from 10 to " + fullCapacity + " units)");
            try {
                while(result){
                    result = setFoodVolume(Integer.parseInt(reader.readLine()));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return result;
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
