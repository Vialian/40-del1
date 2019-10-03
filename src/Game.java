public class Game {

    private int point1; private int point2 ;

    //getterasfasf
    public int getPoint1() {
        System.out.println("get point =" + point1);
        return point1;

    }
    //setter
    public void setPoint(int x1) {
        point1 = x1;
        System.out.println(point1);
    }
    //getter
    public int getPoint2() {
        System.out.println("get point =" + point2);
        return point2;

    }
    //setter
    public void setPoint2(int x2) {
        point2 = x2;
        System.out.println(point2);
    }


    public static void main(String[] args){
        Game game = new Game();
        boolean player = false;
        while(true){
            boolean won1 = checknAdd(roll(), roll(), player);
            System.out.println(game.getPoint1());
            player = !player;
            boolean won2 = checknAdd(roll(), roll(), player);
            System.out.println(game.getPoint2());
            player = !player;
            if(won1 || won2){
                if(won1 & won2){
                    if(game.getPoint1()>game.getPoint2()){
                        game.Player1Wins();
                        break;
                    }
                    if(game.getPoint1()<game.getPoint2()){
                        game.Player2Wins();
                        break;
                    }
                    game.Tie();
                    break;
                }
                if(won1){
                    game.Player1Wins();
                    break;
                }
                game.Player2Wins();
                break;
            }
        }
    }
        public void Player1Wins(){
            System.out.println("spiller 1 har vundet");

        }
        public void Player2Wins(){
        System.out.println("spiller 2 har vundet");
        }
        public void Tie(){
            System.out.println("Lige");
         }

        public static int roll() {
            //Terning function der retunere et tal mellem 1 og 6

            return (int) (Math.random() * 6) + 1;
        }

        public static boolean checknAdd(int r1, int r2, boolean player) {
            Game game = new Game();
          //  System.out.println("roll 1 =" + r1 +" _ roll 2 = "+r2);
            boolean double6 = false; // boolean der viser om der er blevet slået 6,6 slaget før // fiks lige pls
            //add point først
            if (player == true) { //hvis det er spiller 1

                game.setPoint(game.getPoint1() + r1 + r2);
                if (r1 == r2) {
                    //checker om der er blevet slået par
                    if (r1 == 1) { //hvis der er blevet slået 1,1 sættes spillerns point til 1
                       // System.out.println("1,1 er kørt");
                        game.setPoint(0);
                        double6 = false;
                        return false;
                    }
                    if (r1 == 6) { // Hvis der er blevet slået 6,6
                        //System.out.println("6.6 kørt");
                        if (double6 == true) {
                            double6 = false;
                            return true;
                        } else {
                            double6 = true;
                            return checknAdd(roll(), roll(), true); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                        }
                    }
                }
            }
            if (player == false) { //player 2, samme som player1

                game.setPoint(game.getPoint2() + r1 + r2);

                if (r1 == r2) {
                    if (game.getPoint2() >= 40) {
                    double6 = false;
                    return true;
                }

                    if (r1 == 1) {
                        game.setPoint2(0);
                        double6 = false;
                        return false;
                    }
                    if (r1 == 6) {
                        if (double6 == true) {
                            double6 = false;
                            return true;
                        } else {
                            double6 = true;
                            return checknAdd(roll(), roll(), true);
                        }
                    }
                }
            }
            double6 = false; //hvis der ikke er blevet slået par 6,6 eller 1,1, sættes double 6 til false, og der bliver retuneret false
            return false;
        }

}

