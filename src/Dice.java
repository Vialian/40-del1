import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {


    public static void main(String[] args) {


        TestOfDice();
        int point1, point2;
        boolean playerRound;


    }
    private static void TestOfDice()
    {
        Map<Integer, List<Integer>> dice = new HashMap<>();

        for (int i = 2; i <= 12;)
        {
            dice.put(i, new ArrayList<>());
            i++;
        }

        int totalAmount = 0, diceDouble = 0, maxAmount = 1000;
        while(totalAmount < maxAmount)
        {
            Random rand1 = new Random();
            Random rand2 = new Random();

            int temptal1 = rand1.nextInt((6 - 1) + 1) + 1;
            int temptal2 = rand2.nextInt((6 - 1) + 1) + 1;


            int tal = temptal1 + temptal2;
            dice.get(tal).add(1);
            if(temptal1 == temptal2)
                diceDouble++;

            totalAmount++;
        }

        for (int i = 2; i <= 12;)
        {
            System.out.println(i + ": " + dice.get(i).size());
            i++;

        }

        System.out.println("I alt blev der slået: " + diceDouble + " ens");

        int test = 0;
        for (int i = 2; i <= 12;)
        {
            double temp = (dice.get(i).size()*100)/1000;

            test += temp;
            System.out.println(i + ": " + temp + "%");
            i++;
        }

        System.out.println("total: "+test+"%");
    }
}
