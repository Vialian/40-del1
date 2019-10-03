public class Player {
    private String name;
    private int points;
    private int roll1, roll2;

    public Player(String n) {
        this.name = n;
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public String getName() {
        return this.name;
    }

    public boolean lastRoll6() {
        return this.roll1 == 6 && this.roll2 == 6;
    }

    public void setRoll(int r1, int r2) {
        this.roll1 = r1;
        this.roll2 = r2;

        this.points += r1 + r2;
    }
}
