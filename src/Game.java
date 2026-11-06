public class Game {
    Player p1;
    Player p2;
    private Player currentPlayer;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = p1;
    }

    public Player takeTurn() {
        Player playerTakingTurn = currentPlayer;

        System.out.print("\033[2J");
        System.out.flush();

        System.out.println("\n" + getPlayerLabel(playerTakingTurn) + "'s Target Grid:");
        playerTakingTurn.getTargetGrid().display();

        System.out.println("\n" + getPlayerLabel(playerTakingTurn) + "'s Ocean Grid:");
        playerTakingTurn.getOceanGrid().display();

        NextTurnBanner.printOut();
        ConsoleHelper.getInput("");
        currentPlayer = currentPlayer == p1 ? p2 : p1;
        return playerTakingTurn;
    }

    public void play() {
        while (true) {
            takeTurn();
        }
    }

    private String getPlayerLabel(Player player) {
        if (player instanceof AIPlayer) {
            return "AI Player";
        }
        if (player.getName() != null && !player.getName().isEmpty()) {
            return player.getName();
        }
        return player == p1 ? "Player 1" : "Player 2";
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
