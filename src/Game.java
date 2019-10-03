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
    public static boolean double6 = false;

    public static void main(String[] args){

        boolean player = false;
        while(true){
            boolean won1 = checknAdd(roll(), roll(), player);
            //System.out.println(getPoint1() + " | " + getPoint2() );
            player = !player;
            double6 = false;
            boolean won2 = checknAdd(roll(), roll(), player);
            //System.out.println(getPoint2());
            player = !player;
            double6 = false;

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

          //  System.out.println("roll 1 =" + r1 +" _ roll 2 = "+r2);
            // boolean der viser om der er blevet slået 6,6 slaget før // fiks lige pls
            //add point først
            if (player == true) { //hvis det er spiller 1
               // System.out.println("p1 er kørt");
                setPoint1((getPoint1() + r1 + r2));
                if (r1 == r2) {
                    if (getPoint1() >= 40) {

                        System.out.println("player 1 "+r1 + " " + r2);
                        return true;
                    }
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                       // System.out.println("1,1 er kørt");
                        setPoint1(0);

                        return false;
                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6
                        //System.out.println("6.6 kørt");
                        if (double6 == true) {

                            System.out.println("player 1 vundet med 66 __" + r1 + " " + r2);
                            return true;
                        } else {
                            double6 = true;
                            return checknAdd(roll(), roll(), true); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                        }
                    }
                }
            }
            if (player == false) { //player 2, samme som player1
                //System.out.println("p2 er kørt");
                setPoint2(getPoint2() + r1 + r2);

                if (r1 == r2) {
                    if (getPoint2() >= 40) {
                    System.out.println("player 2 "+r1 + " " + r2);
                    return true;
                }

                    if (r1 == 1) {
                        setPoint2(0);

                        return false;
                    }
                    if (r1 == 6) {
                        if (double6 == true) {

                            System.out.println("player 2 vundet med 66 __ "+r1 + " " + r2);
                            return true;
                        } else {
                            double6 = true;
                            return checknAdd(roll(), roll(), false);
                        }
                    }
                }
            }
            double6 = false; //hvis der ikke er blevet slået par 6,6 eller 1,1, sættes double 6 til false, og der bliver retuneret false
            return false;
        }

}

