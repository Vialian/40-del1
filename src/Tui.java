import java.util.Scanner;


public class Tui {
    // *** Copyright © 2019 Alpha Kilimanjaro. All rights reserved.

        private int die1, die2;
        private int roll = 1;
        private Scanner input = new Scanner(System.in);

        private String[][] faces = {
                {
                        "-------",
                        "|     |",
                        "|  *  |",
                        "|     |",
                        "-------"
                }, {
                "-------",
                "| *   |",
                "|     |",
                "|   * |",
                "-------"
        }, {
                "-------",
                "| *   |",
                "|  *  |",
                "|   * |",
                "-------"
        }, {
                "-------",
                "| * * |",
                "|     |",
                "| * * |",
                "-------"
        }, {
                "-------",
                "| * * |",
                "|  *  |",
                "| * * |",
                "-------"
        }, {
                "-------",
                "| * * |",
                "| * * |",
                "| * * |",
                "-------"
        }
        };

        //public TUI() {
          //  input = new Scanner(System.in);
        //}

        public void setDice(int d1, int d2) {
            die1 = d1;
            die2 = d2;
        }

        public void showDice(int r1, int r2) {
            System.out.println("Roll number: " + roll++);
            for (int i = 0; i < 5; i++)
                System.out.println(faces[r1-1][i] + "  " + faces[r2-1][i]);
            System.out.println();
        }

        public void showPoints(int player, int points) {
            System.out.println("Player " + player + " has " + points + " points.");
        }

        public void showPointsToZero(int player) {
            System.out.println("===================<DRAIN PIPE> = = =  =   = > ZERO!");
            System.out.println();
            showPoints(player, 0);
        }

        public boolean requestRoll(boolean p) {
            int player = 1;
            if (p)
                player = 2;

            System.out.println("Roll dice, player " + player + "..... <press ENTER>");
            String in = input.nextLine();
            if(in.equalsIgnoreCase("EXIT"))
                return false;
            return true;
        }

        public void welcome() {
            System.out.println("=============================");
            System.out.println("= ** * ** HyperDice v.0.1.0 =");
            System.out.println("=============================");
        }

        public void theEnd() {
            System.out.println("<THE END>");
        }

        public void displayWinner (int player) {

            System.out.println("* * * ** * * * ** * * * **");
            System.out.println(" *     Player " + player + " WINS !!!!");
            System.out.println("* * * ** ** * ** * * * * *");
        }

        public void displayTie () {
            System.out.println("======================== >   ...<it's a tie!>");
            System.out.println("                    =");
            System.out.println("                =");
            System.out.println("             =");
            System.out.println("          =");
            System.out.println("      =");
            System.out.println("   =");
            System.out.println("=");
            System.out.println("v");
            System.out.println("^");
            System.out.println("i");
            System.out.println("t");
            System.out.println("''");
            System.out.println("s");
            System.out.println("");
            System.out.println("a");
            System.out.println("");
            System.out.println("t");
            System.out.println("i");
            System.out.println("e");
            System.out.println("v");
        }

        //** Test functions ** */


//    public static void main(String[] args) {
        //    TUI tui = new TUI();
        //  tui.runGame();
        //}
    }


