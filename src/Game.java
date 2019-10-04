public class Game {

    private static int point1; private static int point2;

    //getter
    public static int getPoints(boolean player) {
        if (player) return point2;
        else return point1;
    }
    //setter
    public static void setPoints(int x, boolean player) {
        if (player) point2 = x;
        else point1 = x;
       // System.out.println("point1 sat til "+point1);
    }
    //getter

    private static boolean rolled6 = false;
    public boolean getRolled6() {
        return rolled6;

    }
    //setter
    public static void setRolled6(boolean r) {
        rolled6 = r;
        // System.out.println("point1 sat til "+point1);
    }

    public static void main(String[] args){


        Tui tui = new Tui();
        tui.welcome();
        while(true){
            boolean player = false;
            tui.requestRoll(player);
            boolean won1 = checknAdd(roll(), roll(), player);
            tui.showPoints(1,point1);

            player = !player;

            tui.requestRoll(player);
            boolean won2 = checknAdd(roll(),roll(), player);
            tui.showPoints(2,point2);
            player = !player;

            if(won1 || won2){
                if(won1 & won2){
                    if(getPoints(false)>getPoints(true)){
                        tui.displayWinner(1);
                        break;
                    }
                    if(getPoints(false)<getPoints(true)){
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


            return (int) (Math.random() * 6) + 1;
        }

        public static boolean checknAdd(int r1, int r2, boolean player) {

         Tui tui = new Tui();
         tui.showDice(r1,r2);


            // boolean der viser om der er blevet slået 6,6 slaget før // fiks lige pls
            //add point først

                setPoints((getPoints(player) + r1 + r2),player);
                if (r1 == r2) {
                    if (getPoints(player) >= 40 + r1 + r2) {

                        tui.requestRoll(player);
                        checknAdd(roll(), roll(), player);
                        if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1

                            setPoints(0,player);
                        }
                        return true;
                    }
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1

                        setPoints(0,player);

                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6

                        if (rolled6) {

                            tui.requestRoll(player);
                            checknAdd(roll(), roll(), player);
                            return true;
                        }
                        rolled6 = true;
                        tui.requestRoll(player);
                        return checknAdd(roll(), roll(), player); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                    }
                    rolled6 = false;
                    tui.requestRoll(player);
                    return checknAdd(roll(), roll(), false);
                }
            rolled6 = false;
            return false;
        }

}

