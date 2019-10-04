public class Game {

    private static int point1; private static int point2 ;

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
    public static boolean rolled6 = false;

    public static void main(String[] args){

        boolean player = false;
        while(true){
            boolean won1 = checknAdd(roll(), roll(), player);
            //System.out.println(getPoint1() + " | " + getPoint2() );
            player = !player;

            //boolean won2 = checknAdd(roll(), roll(), player);
            boolean won2 = checknAdd(roll(),roll(), player);
            //System.out.println(getPoint2());
            player = !player;

            if(won1 || won2){
                if(won1 & won2){
                    if(getPoint1()>getPoint2()){
                        Player1Wins();
                        break;
                    }
                    if(getPoint1()<getPoint2()){
                        Player2Wins();
                        break;
                    }
                    Tie();
                    break;
                }
                if(won1){
                    Player1Wins();
                    break;
                }
                Player2Wins();
                break;
            }
        }
    }
        public static void Player1Wins(){
            System.out.println("spiller 1 har vundet");

        }
        public static void Player2Wins(){
        System.out.println("spiller 2 har vundet");
        }
        public static void Tie(){
            System.out.println("Lige");
         }

        public static int roll() {
            //Terning function der retunere et tal mellem 1 og 6

            return (int) (Math.random() * 6) + 1;
        }

        public static boolean checknAdd(int r1, int r2, boolean player) {

          System.out.println( r1 +" og "+r2 + player + "points: ");
            // boolean der viser om der er blevet slået 6,6 slaget før // fiks lige pls
            //add point først
            if (player == false) { //hvis det er spiller 1

                setPoint1((getPoint1() + r1 + r2));
                if (r1 == r2) {
                    if (getPoint1() >= 40 + r1 + r2) {
                        System.out.println("player 1 "+r1 + " " + r2);
                        checknAdd(roll(), roll(), false);
                        if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1

                            setPoint1(0);
                        }
                        return true;
                    }
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                        System.out.println("1,1 er kørt");
                        setPoint1(0);

                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6

                        if (rolled6) {
                            System.out.println("player 1 vundet med 66 __" + r1 + " " + r2);
                            checknAdd(roll(), roll(), false);
                            return true;
                        }
                        rolled6 = true;
                        return checknAdd(roll(), roll(), false); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                    }
                    rolled6 = false;
                    return checknAdd(roll(), roll(), false);
                }
            }
            if (player == true) { //hvis det er spiller 1
                // System.out.println("p1 er kørt");
                setPoint2((getPoint2() + r1 + r2));
                if (r1 == r2) {
                    if (getPoint2() >= 40 + r1 + r2) {

                        checknAdd(roll(), roll(), true);
                        if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                            System.out.println("1,1 er kørt");
                            setPoint2(0);
                        }
                        return true;
                    }
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                        System.out.println("1,1 er kørt");
                        setPoint2(0);

                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6

                        if (rolled6) {

                            checknAdd(roll(), roll(), true);
                            return true;
                        }
                        rolled6 = true;
                        return checknAdd(roll(), roll(), true); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                    }
                    rolled6 = false;
                    return checknAdd(roll(), roll(), true);
                }
            }
            rolled6 = false;
            return false;
        }

}

