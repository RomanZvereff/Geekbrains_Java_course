

public class Bowl {
    private final int DEFAULT_BOWL_VOLUME = 20;
    private final int volume;
    private int foodAmount;

    public Bowl(int maxVolume) {
        this.volume = maxVolume < 0 ? DEFAULT_BOWL_VOLUME : maxVolume;
    }

    public void fill() {
        System.out.println("Миска наполнена!");
        this.foodAmount = volume;
    }

    public int foodLeft() {
        return foodAmount;
    }

    /*
     * Метод вынимает определенное количество еды из миски
     * Возвращает true, если еды в миске достаточно
     * Возвращает false, если еды не достаточно, еда при этом не вынимается.
     */
    public boolean getFood(int volume) {
        boolean result = false;

        if (foodAmount - volume >= 0) {
            foodAmount -= volume;
            result = true;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Миска объемом " + volume + ". В миске " + foodAmount + " еды.";
    }

    public int getVolume() {
        return volume;
    }
}
