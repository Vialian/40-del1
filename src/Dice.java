import java.text.NumberFormat;
import java.util.*;

public class Dice {

//    public static void main(String[] args) {
//        TestOfDice();
//    }

    private static void TestOfDice()
    {
        int totalAmount = 0, diceDouble = 0, maxAmount = 1000, diceMaxSide = 6, diceMinSide = 1;
        int diceThrowMax = diceMaxSide*2, diceThrowMin= diceMinSide*2;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumIntegerDigits(2);
        Map<Integer, List<Integer>> dice = new HashMap<>();

        //Adder alle mulige kast til en hashmap
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
            //adder 1 til det terning kast der er blevet slået
            dice.get(tal).add(1);
            if(temptal1 == temptal2)
                diceDouble++;

            totalAmount++;
        }

        //Skriver antal af hver slag
        for (int i = diceThrowMin; i <= diceThrowMax;)
        {
            System.out.println(i + ": " + dice.get(i).size());
            i++;

        }

        System.out.println("I alt blev der slået: " + diceDouble + " ens");

        double procent = 0;
        double totalProcent = 0;
        //skriver % af hver slag
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
