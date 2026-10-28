public class Game {
    Player p1;
    Player p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play() {
        System.out.println("\nPlayer 1's Target Grid:");
        p1.getTargetGrid().display();

        System.out.println("\nPlayer 1's Ocean Grid:");
        p1.getOceanGrid().display();
    }

    private void playAgain() {
        System.out.println("                Would you like to play another game with the same players and rules, start a new game, or go back to the start menu?");
        System.out.println("                                     (P)lay Again - (N)ew Game - (B)ack to Menu");

        while(true){
            String selection = ConsoleHelper.getInput("");
            selection = selection.toLowerCase().trim();
            if (selection.equals('p')){
                System.out.println("Starting another game...");
                play();
                break;
            }
            else if (selection.equals('n')){
                System.out.println("Starting a new game...");
                new GameConfig().start();
                break;
            } else if (selection.equals('b')){
                System.out.println("Going back to start menu...");
                new StartMenu().display();
                break;
            } else {
                System.out.println("Invalid selection. Please input either P, N, or B.");
            }
        }
    }
}
