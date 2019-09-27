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

        double tal1 = 0,tal2 = 0,tal3 = 0,tal4 = 0,tal5 = 0,tal6 = 0, totalAmount = 0;

        while(totalAmount < 1000)
        {
            Random r = new Random();
            double tal = r.nextInt((6 - 1) + 1) + 1;
            if (tal == 1)
                tal1++;
            else if (tal == 2)
                tal2++;
            else if (tal == 3)
                tal3++;
            else if (tal == 4)
                tal4++;
            else if (tal == 5)
                tal5++;
            else if (tal == 6)
                tal6++;
            totalAmount++;
        }
        System.out.println("1: " + tal1 + " 2: " + tal2 + " 3: " + tal3 + " 4:" + tal4 + " 5: " + tal5 + " 6: " + tal6);


        double procentTal1 = (tal1/1000)*100;
        double procentTal2 = (tal2/1000)*100;
        double procentTal3 = (tal3/1000)*100;
        double procentTal4 = (tal4/1000)*100;
        double procentTal5 = (tal5/1000)*100;
        double procentTal6 = (tal6/1000)*100;

        System.out.println("1: " + procentTal1 + "% 2: " + procentTal2 + "% 3: " + procentTal3 + "% 4:" + procentTal4 +
                "% 5: " + procentTal5 + "% 6: " + procentTal6 + "%");
    }
}
