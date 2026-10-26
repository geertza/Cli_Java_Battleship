public class Game {
    Player p1;
    Player p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play() {
        System.out.println("\nPlayer 1's Ocean Grid:");
        p1.getOceanGrid().display();

        System.out.println("\nPlayer 1's Target Grid:");
        p1.getTargetGrid().display();
    }
}
