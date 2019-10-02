public class Game {

    private int point1; private int point2;
    private boolean player;
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
