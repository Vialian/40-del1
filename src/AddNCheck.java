public class AddNCheck {
    Game game = new Game();

    public static int roll() {

        return (int) (Math.random() * 6) + 1;
    }

    public boolean checkRoll(int r1, int r2, boolean player) {
        boolean double6 = false;
        //add point først

        if (player = true) {
            if (game.getPoint1() >= 40) {
                return true;
            }

            game.setPoint(game.getPoint1() + r1 + r2);
            if (r1 == r2) {
                if (r1 == 1) {
                    game.setPoint(0);
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
        if (player = false) { //player 2
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
        double6 = false;
        return false;
    }
}