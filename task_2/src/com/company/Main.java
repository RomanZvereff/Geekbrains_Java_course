package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {4, 15, 1, 7, 90, 1, 4, 5, 18};
        setZeroOneArray();
        setArrIncrementByThree();
        lessThenSix();
        diagonalItems();
        getMinMax();
        System.out.println(checkBalance(arr));
    }

   /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    public static void setZeroOneArray(){
        int[] zeroOne = new int[10];
        for (int i = 0; i < zeroOne.length; i++){
            if(Math.random() < 0.5){
                zeroOne[i] = 0;
            }else{
                zeroOne[i] = 1;
            }
        }
        printArr(zeroOne);
        replace(zeroOne);
        printArr(zeroOne);
    }

    public static void replace(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }
    }

    public static void printArr(int[] arr){
        for (int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void setArrIncrementByThree(){
        int[] arr = new int[8];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = j;
            j += 3;
        }
        printArr(arr);
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
    public static void lessThenSix(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6){
                arr[i] *= 2;
            }
        }
        printArr(arr);
    }
    
    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
    public static void diagonalItems(){
        int[][] arr = new int[5][5];
        int j = 4;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][j] = 1;
            j--;
        }
        for (int i = 0; i < arr.length ; i++){
            for (int k = 0; k < arr[0].length; k++) {
                System.out.print(arr[i][k] + "\t");
            }
            System.out.println();
        }
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void getMinMax(){
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int maxInt = Integer.MIN_VALUE;
        int minInt = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++){
            maxInt = (maxInt < arr[i]) ? arr[i] : maxInt;
            minInt = (minInt > arr[i]) ? arr[i] : minInt;
        }
        System.out.println("maximum: " + maxInt + "\t minimum: " + minInt);
    }

    /*6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;*/
    public static boolean checkBalance(int[] arr){
        int mid = Math.round((float)arr.length / 2);
        int firstPartSum = 0;
        int secondPartSum = 0;
        for (int i = 0; i < mid; i++) {
            firstPartSum += arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            secondPartSum += arr[i];
        }
        return(firstPartSum == secondPartSum);
    }
}
