public class AddNCheck {

    private int roll() {

        return (int) (Math.random() * 6) + 1;
    }

    private boolean checkRoll(int r1, int r2, boolean player) {

        //add point først

        if(player = true){
            setPl1p() = getPl1p() + r1 + r2;
        }
        if(player = false){
            setPl2p() = getPl2p() + r1 + r2;
        }

        if (r1 == r2) {
            if(getPl1point() >= 40){
                return true;
            }
            if (r1 == 6 && r2 == 6) {

                if (player == true) { //spiller 1 tur
                    if (p1Double6 == true) {
                        return true;
                    } else {
                        p1Double6 == true;
                        return checkRoll(roll(),roll(),false);
                    }
                }
            }
            if (player == false) { //spiller 2 tur
                if(getPl2point == 40){
                    return true;
                }

                if (p2Double6 == true) {
                    return true;
                } else {
                    p2Double6 == true;

                }

            }
            if (r1 == 1) {
                if(player == true)
                    setPl1Point(1);
                return false;
            }
        } else { // hvis r1 ikke er lig r2
            if(player = false)
               setplayer(false);
            if(player == false)
                setplayer(true);
            return false;
        }
    }
}
