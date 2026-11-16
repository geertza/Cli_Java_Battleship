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
        String selection = ConsoleHelper.getInput("Press enter to simulate turn or P to pause: ");
        if (selection != null
                && (selection.trim().equalsIgnoreCase("p") || selection.trim().equalsIgnoreCase("pause"))) {
            openMenu();
        }
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

    private void openMenu() {
        while (true) {
            ClearScreen.wipe();
            System.out.println("The game is now paused. Press enter to resume or choose another option.");
            System.out.println("             (S)ettings - Sa(V)e - (R)ules - (Q)uit");

            String input = ConsoleHelper.getInput("");
            if (input == null) {
                return;
            }
            String selection = input.trim().toLowerCase();
            if (selection.isEmpty() || selection.equals("p") || selection.equals("resume")) {
                return;
            } else if (selection.equals("s") || selection.equals("settings")) {
                System.out.println("Settings will be available soon.");
                ConsoleHelper.getInput("Press enter to return to the pause menu.");
            } else if (selection.equals("v") || selection.equals("save")) {
                System.out.println("This is a placeholder. Saving is not available yet. Your game has not been saved.");
                ConsoleHelper.getInput("Press enter to return to the pause menu.");
            } else if (selection.equals("r") || selection.equals("rules")) {
                Rules.printRules();
            } else if (selection.equals("q") || selection.equals("quit")) {
                System.out.println("The game will quit without saving. Are you sure you would like to do this?");
                System.out.println("                           (Y)es - (N)o");
                input = ConsoleHelper.getInput("");
                if ((input.equalsIgnoreCase("yes")) || (input.equalsIgnoreCase("y"))) {
                    App.quit();
                }
                return;
            } else {
                System.out.println("Invalid selection. Press enter to resume, or choose R or Q.");
                ConsoleHelper.getInput("");
            }
        }
    }

    private void playAgain() {
        System.out.println("                Would you like to play another game with the same players and rules, start a new game, or go back to the start menu?");
        System.out.println("                                     (P)lay Again - (N)ew Game - (B)ack to Menu");

        while(true){
            String selection = ConsoleHelper.getInput("");
            selection = selection.toLowerCase().trim();
            if (selection.equals("p")){
                System.out.println("Starting another game...");
                play();
                break;
            }
            else if (selection.equals("n")){
                System.out.println("Starting a new game...");
                new GameConfig().start();
                break;
            } else if (selection.equals("b")){
                System.out.println("Going back to start menu...");
                new StartMenu().display();
                break;
            } else {
                System.out.println("Invalid selection. Please input either P, N, or B.");
            }
        }
    }
}
