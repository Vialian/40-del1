public class AddNCheck {
    Game game = new Game();

    public static int roll() {
        //Terning function der retunere et tal mellem 1 og 6

        return (int) (Math.random() * 6) + 1;
    }

    public boolean checkRoll(int r1, int r2, boolean player) {
        boolean double6 = false; // boolean der viser om der er blevet slået 6,6 slaget før
        //add point først
        if (player = true) { //hvis det er spiller 1
            game.setPoint(game.getPoint1() + r1 + r2);
            if (game.getPoint1() >= 40) { //Ser om spillern har 40 point eller mere
                double6 = false; //der er ikke blevet slået 6,6
                return true; //spillern har vundet
            }

            if (r1 == r2) { //checker om der er blevet slået par
                if (r1 == 1) { //hcis der er blevet slået 1,1 sættes spillerns point til 1
                    game.setPoint(0);
                    double6 = false;
                    return false;
                }
                if (r1 == 6) { // Hvis der er blevet slået 6,6
                    if (double6 == true) {
                        double6 = false;
                        return true;
                    } else {
                        double6 = true;
                        return checkRoll(roll(), roll(), true); //hvis der er blevet slået 6,6 får spillern et ekstra slag
                    }
                }
            }
        }
        if (player = false) { //player 2, samme som player1
            game.setPoint(game.getPoint2() + r1 + r2);
            if (game.getPoint2() >= 40) {
                double6 = false;
                return true;
            }

            if (r1 == r2) {
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
                        return checkRoll(roll(), roll(), true);
                    }
                }
            }
        }
        double6 = false; //hvis der ikke er blevet slået par 6,6 eller 1,1, sættes double 6 til false, og der bliver retuneret false
        return false;
    }
}