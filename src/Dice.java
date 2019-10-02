import java.text.NumberFormat;
import java.util.*;
public class Dice {


    public static void main(String[] args) {


        TestOfDice();
        int point1, point2;
        boolean playerRound;
        int skalikkebruges = 100;
        int skalikkebruger_2 = 100;

    }
    private static void TestOfDice()
    {

        int totalAmount = 0, diceDouble = 0, maxAmount = 1000, diceMaxSide = 6, diceMinSide = 1;
        int diceThrowMax = diceMaxSide*2, diceThrowMin= diceMinSide*2;
        //test
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

        double procent = 0;
        double totalProcent = 0;
        for (int i = diceThrowMin; i <= diceThrowMax;)
        {
            procent = ((double)(dice.get(i).size())/maxAmount)*100;
            totalProcent += procent;
            System.out.println(i + ": " + nf.format(procent)  + "%");
            i++;
        }

        System.out.println("total: "+(int)totalProcent+"%");
    }
}
