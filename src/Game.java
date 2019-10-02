public class Game {

    private int point1; private int point2;
    private boolean player;

    //getter
    public int getPoint1() {
        return point1;
    }
    //setter
    public void setPoint(int x1) {
        this.point1 = x;
    }
    //getter
    public int getPoint2() {
        return point2;
    }
    //setter
    public void setPoint2(int x2) {
        this.point2 = x2;
    }


    public static void main(String[] args){
        while(true){
            boolean won1 = CheckandAdd(AddNCheck.roll(), AddNCheck.roll(), player);
            player = !player;
            boolean won2 = CheckandAdd(AddNCheck.roll(), AddNCheck.roll(), player);
            player = !player;
            if(won1 || won2){
                if(won1 & won2){
                    if(point1>point2){
                        Player1Wins();
                        break;
                    }
                    if(point1<point2){
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
}
