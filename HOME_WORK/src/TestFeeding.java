

import java.util.Random;

public class TestFeeding {
    private static Random random = new Random();

    public static void main(String[] args) {
        // Создаем миску
        Bowl bowl = new Bowl(15);
        System.out.println(bowl.toString());
        bowl.fill();
        System.out.println(bowl.toString());

        //Создаем котов
        Cat[] clowder = new Cat[5];
        for (int i = 0; i < clowder.length; i++) {
            clowder[i] = new Cat(random.nextFloat() * 300f, random.nextFloat() * 3f, random.nextInt(20));
            System.out.println(clowder[i].toString());
        }

        //Кормим котов
        for (int i = 0; i < clowder.length; i++) {
            System.out.println("Кормим кота " + (i + 1) + " из миски.");
            System.out.println(bowl.toString());
            clowder[i].eat(bowl);
            System.out.println(clowder[i]);
            if (clowder[i].isHungry()) {
                if (bowl.getVolume() >= clowder[i].getStomachVolume()) {
                    bowl.fill();
                    System.out.println(bowl.toString());
                    clowder[i].eat(bowl);
                    System.out.println(clowder[i]);
                } else {
                    System.out.println("Миска слишком маленькая!");
                }
            }
            System.out.println();
        }
    }
}
