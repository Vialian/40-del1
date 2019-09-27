import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {


    public static void main(String[] args) {


        TestOfDice();
        int point1, point2;
        boolean playerRound;


    }
    private static void TestOfDice()
    {

        double tal2 = 0,tal3 = 0,tal4 = 0,tal5 = 0,tal6 = 0, tal7 = 0, tal8 = 0, tal9 = 0, tal10 = 0, tal11 = 0, tal12 = 0, totalAmount = 0;
int diceDouble = 0;
        while(totalAmount < 1000)
        {
            Random rand1 = new Random();

            Random rand2 = new Random();
            double temptal1 = rand1.nextInt((6 - 1) + 1) + 1;
            double temptal2 = rand2.nextInt((6 - 1) + 1) + 1;
            double tal = temptal1 + temptal2;
            if (tal == 2)
                tal2++;
            else if (tal == 3)
                tal3++;
            else if (tal == 4)
                tal4++;
            else if (tal == 5)
                tal5++;
            else if (tal == 6)
                tal6++;
            else if (tal == 7)
                tal7++;
            else if (tal == 8)
                tal8++;
            else if (tal == 9)
                tal9++;
            else if (tal == 10)
                tal10++;
            else if (tal == 11)
                tal11++;
            else if (tal == 12)
                tal12++;
            totalAmount++;
            if(temptal1 == temptal2)
                diceDouble++;

        }
        System.out.println("2: " + tal2 + " 3: " + tal3 + " 4:" + tal4 + " 5: " + tal5 + " 6: " + tal6 +
                "7: " + tal7 + " 8: " + tal8 + " 9:" + tal9 + " 10: " + tal10 + " 11: " + tal11 + " 12: " + tal12);

        double procentTal2 = (tal2/1000)*100;
        double procentTal3 = (tal3/1000)*100;
        double procentTal4 = (tal4/1000)*100;
        double procentTal5 = (tal5/1000)*100;
        double procentTal6 = (tal6/1000)*100;
        double procentTal7 = (tal7/1000)*100;
        double procentTal8 = (tal8/1000)*100;
        double procentTal9 = (tal9/1000)*100;
        double procentTal10 = (tal10/1000)*100;
        double procentTal11= (tal11/1000)*100;
        double procentTal12 = (tal12/1000)*100;

        System.out.println("2: " + procentTal2 + "% 3: " + procentTal3 + "% 4:" + procentTal4 +
                "% 5: " + procentTal5 + "% 6: " + procentTal6 + "% 7: " + procentTal7 + "% 8: "
                + procentTal8 + "% 9: " + procentTal9 + "% 10: "
                + procentTal10 + "% 11: " + procentTal11 + "% 12: " + procentTal12 + "%");
        System.out.println("double throw: " + diceDouble);
    }
}
