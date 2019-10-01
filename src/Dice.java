import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {


    public static void main(String[] args) {


        TestOfDice();
        int point1, point2;
        boolean playerRound;
        int skalikkebruges = 100;

    }
    private static void TestOfDice()
    {
        int totalAmount = 0, diceDouble = 0, maxAmount = 1000, diceMaxSide = 6, diceMinSide = 1;
        int diceThrowMax = diceMaxSide*2, diceThrowMin= diceMinSide*2;
        Map<Integer, List<Integer>> dice = new HashMap<>();

        for (int i = diceThrowMin; i <= diceThrowMax;)
        {
            dice.put(i, new ArrayList<>());
            i++;
        }

        while(totalAmount < maxAmount)
        {
            Random rand1 = new Random();
            Random rand2 = new Random();

            int temptal1 = rand1.nextInt(diceMaxSide )  + 1;
            int temptal2 = rand2.nextInt(diceMaxSide) + 1;


            int tal = temptal1 + temptal2;
            dice.get(tal).add(1);
            if(temptal1 == temptal2)
                diceDouble++;

            totalAmount++;
        }

        for (int i = diceThrowMin; i <= diceThrowMax;)
        {
            System.out.println(i + ": " + dice.get(i).size());
            i++;

        }

        System.out.println("I alt blev der slået: " + diceDouble + " ens");

        int totalProcent = 0;
        for (int i = diceThrowMin; i <= diceThrowMax;)
        {
            double temp = (dice.get(i).size()*100)/1000;

            totalProcent += temp;
            System.out.println(i + ": " + temp + "%");
            i++;
        }

        System.out.println("total: "+totalProcent+"%");
    }
}
