import DiceTui.TUI;

import java.util.Random;

public class Game {
    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");

    private static int point1; private static int point2 ;

    private static TUI tui = null;
    private static TUI getTui() {
        if (tui == null) tui = new TUI();
        return tui;
    }

    //getterasfasf
    public static int getPoint1() {
       // System.out.println("get point 1 =" + point1);
        return point1;

    }
    //setter
    public static void setPoint1(int x1) {
        point1 = x1;
       // System.out.println("point1 sat til "+point1);
    }
    //getter
    public static int getPoint2() {
        //System.out.println("get point 2 =" + point2);
        return point2;

    }
    //setter
    public static void setPoint2(int x2) {
        point2 = x2;
       // System.out.println("point1 sat til "+ point2);
    }
    public static boolean double6 = false;

    public static void main(String[] args){
        TUI tui = getTui();
        tui.welcome();

        while(true){
            tui.requestRoll(1);
            int roll1 = roll();
            int roll2 = roll();

            tui.setDice(roll1, roll2);
            tui.showDice();

            boolean won1 = checknAdd(roll1, roll2, true);
            //System.out.println(getPoint1() + " | " + getPoint2() );

            double6 = false;

            tui.requestRoll(2);
            roll1 = roll();
            roll2 = roll();

            tui.setDice(roll1, roll2);
            tui.showDice();

            boolean won2 = checknAdd(roll1, roll2, false);
            //System.out.println(getPoint2());
            double6 = false;

            if(won1 || won2){
                if(won1 & won2){
                    if(getPoint1()>getPoint2()){
                        tui.displayWinner(1);
                        break;
                    }
                    if(getPoint1()<getPoint2()){
                        tui.displayWinner(2);
                        break;
                    }
                    tui.displayTie();
                    break;
                }
                if(won1){
                    tui.displayWinner(1);
                    break;
                }
                tui.displayWinner(2);
                break;
            }
        }
    }

        public static int roll() {
            //Terning function der retunere et tal mellem 1 og 6
            Random rand = new Random();
            return rand.nextInt(6) + 1;
        }

        public static boolean checknAdd(int r1, int r2, boolean player) {
            TUI tui = getTui();
          //  System.out.println("roll 1 =" + r1 +" _ roll 2 = "+r2);
            // boolean der viser om der er blevet slået 6,6 slaget før // fiks lige pls
            //add point først
            if (player == true) { //hvis det er spiller 1
               // System.out.println("p1 er kørt");
                setPoint1((getPoint1() + r1 + r2));
                tui.showPoints(1, getPoint1());

                if (r1 == r2) {
                    if (getPoint1() >= 40) {

                        return true;
                    }
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                       // System.out.println("1,1 er kørt");
                        setPoint1(0);
                        tui.showPointsToZero(1);
                        return false;
                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6
                        //System.out.println("6.6 kørt");
                        if (double6 == true) {

                            tui.displayWinner(1);
                            return true;
                        } else {
                            double6 = true;

                            tui.requestRoll(1);
                            int roll1 = roll();
                            int roll2 = roll();

                            tui.setDice(roll1, roll2);
                            tui.showDice();

                            return checknAdd(roll1, roll2, true); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                        }
                    }
                }
            }
            if (player == false) { //player 2, samme som player1
                //System.out.println("p2 er kørt");
                setPoint2(getPoint2() + r1 + r2);
                tui.showPoints(2, getPoint2());

                if (r1 == r2) {
                    if (getPoint2() >= 40) {

                    return true;
                }

                    if (r1 == 1) {
                        setPoint2(0);
                        tui.showPointsToZero(2);
                        return false;
                    }
                    if (r1 == 6) {
                        if (double6 == true) {

                            tui.displayWinner(2);

                            return true;
                        } else {
                            double6 = true;

                            tui.requestRoll(2);
                            int roll1 = roll();
                            int roll2 = roll();

                            tui.setDice(roll1, roll2);
                            tui.showDice();

                            return checknAdd(roll1, roll2, false);
                        }
                    }
                }
            }
            double6 = false; //hvis der ikke er blevet slået par 6,6 eller 1,1, sættes double 6 til false, og der bliver retuneret false
            return false;
        }

}

