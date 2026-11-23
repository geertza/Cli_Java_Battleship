public class Game {
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Player otherPlayer;
    private ShotResult result;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.currentPlayer = p1;
        this.otherPlayer = p2;
    }

    public void play() {
        boolean isSinglePlayerGame = p1 instanceof AIPlayer || p2 instanceof AIPlayer;
        System.out.printf("\nHey %s! It's time to place your ships!!! Make sure the other player isn't looking at your screen while you do this.\n", p1.getName());
        p1.placeShips();
        if (p2 instanceof HumanPlayer) {
            System.out.printf("Hey %s! It's time to place your ships!!! Make sure the other player isn't looking at your screen while you do this.\n", p2.getName());
        }
        p2.placeShips();
        while (true) {
            ClearScreen.wipe();

            if (currentPlayer instanceof HumanPlayer) {
                if (result != null) {
                    displayPreviousTurnOutcome(result);
                }
                System.out.printf("It's now %s's Turn!\n", currentPlayer.getName());

                String selection = ConsoleHelper.getInput("Press enter to take a shot or P to pause: ");
                if (selection != null
                        && (selection.trim().equalsIgnoreCase("p") || selection.trim().equalsIgnoreCase("pause"))) {
                    openMenu();
                    continue;
                }
            }

            Coordinate shot = currentPlayer.takeShot();
            result = otherPlayer.receiveShot(shot);
            currentPlayer.receiveShotResult(result);

            if (!isSinglePlayerGame) {
                ConsoleHelper.getInput("Press enter to switch players: ");
            }
            
            if (otherPlayer.shipsAreSunk()) {
                displayVictoryScreen(currentPlayer);
            }
            
            if (!isSinglePlayerGame) {
                NextTurnBanner.printOut();
                ConsoleHelper.getInput("");
            }
            currentPlayer = currentPlayer == p1 ? p2 : p1;
            otherPlayer = otherPlayer == p1 ? p2 : p1;
        }
    }


    private void displayVictoryScreen(Player winner) {
        ClearScreen.wipe();
        System.out.println("========================================");
        System.out.println("              VICTORY!");
        System.out.println("       " + getPlayerLabel(winner) + " wins!");
        System.out.println("========================================");
        ConsoleHelper.getInput("Press enter to choose to play again or quit!");
        playAgain();

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
            System.out.println("             (O)ptions - (S)ave - (R)ules - (Q)uit");

            String input = ConsoleHelper.getInput("");
            if (input == null) {
                return;
            }
            String selection = input.trim().toLowerCase();
            if (selection.isEmpty() || selection.equals("p") || selection.equals("resume")) {
                return;
            } else if (selection.equals("o") || selection.equals("options")) {
                System.out.println("Options will be available soon.");
                ConsoleHelper.getInput("Press enter to return to the pause menu.");
            } else if (selection.equals("s") || selection.equals("save")) {
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
                System.out.println("Invalid selection. Press enter to resume, or choose O, S, R, or Q.");
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

    private void displayPreviousTurnOutcome(ShotResult sr) {
        ShotOutcome outcome = sr.getOutcome();
        switch (outcome) {
            case ShotOutcome.MISS:
                System.out.println("Your opponent shot a Miss at " + sr.getShot() + ".\n");
                break;
            case HIT:
                System.out.println("Your opponent scored a Hit at " + sr.getShot() + "!\n");
                break;
            case SUNK:
                System.out.println("Your opponent sunk your " + sr.getShipName() + " at " + sr.getShot() + "!\n");
                break;
        }
    }
}
