public class GameConfig {
    private Game game;
    private Player p1 = new HumanPlayer();
    private Player p2;

    public void start() {

        System.out.println("                Would you like to resume a previous save game or make a new game?");
        System.out.println("                                     (N)ew Game - (L)oad Game");

        GetSelection("n", "l");
        ClearScreen.wipe();
        System.out.println("                Would you like to play a 2 player game or 1 player game?");
        System.out.println("                                     (2) Player - (1) Player");

        GetSelection("2", "1");

        if (p2 instanceof AIPlayer) {
            p2.setShipFactory(new AutoShipFactory());
        }

        ClearScreen.wipe();
        System.out.println("                What is your name Player 1?");
        String name = ConsoleHelper.getInput("");
        p1.setName(name);

        ClearScreen.wipe();
        if (p2 instanceof HumanPlayer) {
            System.out.println("                What is your name Player 2?");
            String name2 = ConsoleHelper.getInput("");
            p2.setName(name2);
        }

        ClearScreen.wipe();
        configureShipPlacement(p1);
        if (p2 instanceof HumanPlayer) {
            configureShipPlacement(p2);
        }

        p1.placeShips();
        p2.placeShips();

        game = new Game(p1, p2);
        game.play();
    }

    private void configureShipPlacement(Player player) {
        while (true) {
            System.out.printf("\n                 Hey %s, would you like to place ships manually or automatically?\n",
                    player.getName());
            System.out.println("                                    (M)anual - (A)utomatic");
            String selection = ConsoleHelper.getInput("").toLowerCase().trim();
            ClearScreen.wipe();

            if (selection.equals("m") || selection.equals("manual")) {
                System.out.println("Time to place your Ships!!");
                System.out.println("Make sure the other player can't see where you are placing your screen!!");
                player.getOceanGrid().display();
                player.setShipFactory(new ManualShipFactory(player.getOceanGrid()));
                return;
            } else if (selection.equals("a") || selection.equals("automatic")) {
                player.setShipFactory(new AutoShipFactory());
                return;
            }

            System.out.println("Invalid selection. Please choose manual or automatic placement.");
        }
    }

    private void GetSelection(String option1, String option2) {
        while(true){
            String selection = ConsoleHelper.getInput("");
            selection = selection.toLowerCase().trim();
            if (selection.equals(option1)){
                if (option1.equals("n")){
                    System.out.println("Starting a new game...");
                } else if (option1.equals("2")){
                    System.out.println("Starting a 2 player game...");
                    p2 = new HumanPlayer();
                }
                break;
            }
            else if (selection.equals(option2)){
                if (option2.equals("l")){
                    System.out.println("This is where a previous save game would be loaded.");
                    continue;
                } else if (option2.equals("1")){
                    System.out.println("Starting a 1 player game...");
                    p2 = new AIPlayer();
                }
                break;
            } else {
                System.out.println("Invalid selection. Please input either " + option1 + " or " + option2 + ".");
            }
        }
    }
}