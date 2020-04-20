
/*
 * Класс Кот
 */

public class Cat extends Animal {
    private final float DEFAULT_MAX_RUN = 200f;
    private final float DEFAULT_MAX_JUMP = 2f;
    private final int DEFAULT_STOMACH = 10;

    private final float catMaxRun;
    private final float catMaxJump;
    private final int catStomachVolume;
    private boolean hungry = true;

    public Cat() {
        catMaxRun = DEFAULT_MAX_RUN;
        catMaxJump = DEFAULT_MAX_JUMP;
        catStomachVolume = DEFAULT_STOMACH;
    }

    public Cat(int stomachVolume) {
        catMaxRun = DEFAULT_MAX_RUN;
        catMaxJump = DEFAULT_MAX_JUMP;
        catStomachVolume = stomachVolume < 0 ? DEFAULT_STOMACH : stomachVolume;
    }

    public Cat(float maxRun, float maxJump, int stomachVolume) {
        catMaxRun = maxRun < 0 ? DEFAULT_MAX_RUN : maxRun;
        catMaxJump = maxJump < 0 ? DEFAULT_MAX_JUMP : maxJump;
        catStomachVolume = stomachVolume < 0 ? DEFAULT_STOMACH : stomachVolume;
    }

    @Override
    public void run(float distance) {
        if (distance <= 0) {
            System.out.println("run: Значение должно быть больше ноля");
        } else if (distance > catMaxRun) {
            System.out.printf("run: Пробежал %5.2f метров и упал. Может бензин кончился?\n", catMaxRun);
        } else {
            System.out.printf("run: Успешно пробежал %5.2f метров\n", distance);
        }
    }

    @Override
    public void swim(float distance) {
        if (distance <= 0) {
            System.out.println("swim: Значение должно быть больше ноля");
        } else {
            System.out.println("swim: Прыгнул в воду и утонул.");
        }
    }

    @Override
    public void jump(float height) {
        if (height <= 0) {
            System.out.println("jump: Значение должно быть больше ноля");
        } else if (height > catMaxJump) {
            System.out.printf("jump: Подпрыгнул на %5.2f метров и уткнулся в препятствие.\n", catMaxJump);
        } else {
            System.out.printf("jump: Успешно перепрыгнул препятствие высотой %5.2f метров\n", height);
        }
    }

    public void eat(Bowl bowl) {
        if (hungry && bowl.getFood(catStomachVolume)) {
            System.out.println("Кот ест из миски");
            hungry = false;
        } else {
            System.out.println("Кот не трогает еду");
        }
    }

    public boolean isHungry() {
        return hungry;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Кот может пробежать ");
        stringBuilder.append(catMaxRun);
        stringBuilder.append(" метров, перепрыгнуть ");
        stringBuilder.append(catMaxJump);
        stringBuilder.append(" метров. Желудок объемом ");
        stringBuilder.append(catStomachVolume);
        stringBuilder.append(". ");
        stringBuilder.append(hungry ? "Кот голоден." : "Кот сыт.");
        return stringBuilder.toString();
    }

    public int getStomachVolume() {
        return catStomachVolume;
    }
}
