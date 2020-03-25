package com.company;

public class Main {
    //Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        //Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte a = 127;
        short b = 32767;
        int c = 2147483647;
        long d = 2147483648L;
        float e = 35.99f;
        double f = 99.999;
        char g = 65;
        boolean h = true;
    }

    //Написать метод, вычисляющий выражение a * (b + (c / d))
    public static double getCalculation(double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    //Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно)
    public static boolean sumInRange(int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное
    public static void positiveOrNegative(int num){
        if(num < 0){
            System.out.println("Number is negative.");
        }else{
            System.out.println("Number is positive.");
        }
    }

    //Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное
    public static boolean isNegative(int num){
        return (num < 0);
    }

    //Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void printHello(String name){
        System.out.println("Привет, " + name);
    }

    //Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    public static void leapYear(int year){
        if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
            System.out.println(year + " год - высокосный.");
        }
    }
}
