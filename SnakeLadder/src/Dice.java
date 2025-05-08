import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    Random random = new Random();
    private final int mini = 1;
    private final int maxi =6;
    private final int countOfDice;
    public Dice(int countOfDice) {
        this.countOfDice = countOfDice;
    }

    public int rollDice()
    {
        int sum = 0;
        int diceCount = countOfDice;
        while(diceCount>0)
        {
            sum += ThreadLocalRandom.current().nextInt(mini,maxi+1);
            System.out.println("sum "+sum);
            diceCount--;
        }
        return sum;
    }
}
