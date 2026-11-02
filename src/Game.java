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

        ConsoleHelper.getInput("\nPress Enter to switch to the next player...");
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
}
