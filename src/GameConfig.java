public class GameConfig {
    private Game game;
    private Player p1;
    private Player p2;
    private boolean isTwoPlayerGame;
    private String name1;
    private String name2;

    public void start() {

        System.out.println("                Would you like to resume a previous save game or make a new game?");
        System.out.println("                                     (N)ew Game - (L)oad Game");

        GetSelection("n", "l");
        ClearScreen.wipe();
        System.out.println("                Would you like to play a 2 player game or 1 player game?");
        System.out.println("                                     (2) Player - (1) Player");

        GetSelection("2", "1");

        ClearScreen.wipe();
        System.out.println("                What is your name Player 1?");
        name1 = ConsoleHelper.getInput("");

        ClearScreen.wipe();
        if (isTwoPlayerGame) {
            System.out.println("                What is your name Player 2?");
            name2 = ConsoleHelper.getInput("");
        }

        ClearScreen.wipe();
        System.out.printf("\n                 Hey %s, would you like to place ships manually or automatically?\n",
                    name1);
        System.out.println("                                    (M)anual - (A)utomatic");
        GetSelection("m", "a");

        if (isTwoPlayerGame) {
            ClearScreen.wipe();
            System.out.printf("\n                 Hey %s, would you like to place ships manually or automatically?\n",
                    name2);
            System.out.println("                                    (M)anual - (A)utomatic");
            GetSelection("a", "m");
        } else {
            p2 = new AIPlayer(); 
        }
        game = new Game(p1, p2);
        game.play();
    }

    private void GetSelection(String option1, String option2) {
        while(true){
            String selection = ConsoleHelper.getInput("");
            selection = selection.toLowerCase().trim();
            if (selection.equals(option1)){
                if (option1.equals("n")){
                } else if (option1.equals("2")){
                    isTwoPlayerGame = true;
                } else if (option1.equals("m")){
                    p1 = new HumanPlayer(name1, new ManualShipFactory());
                } else if (option1.equals("a")){
                    p2 = new HumanPlayer(name2, new AutoShipFactory());
                }
                break;
            }
            else if (selection.equals(option2)){
                if (option2.equals("l")){
                    System.out.println("This is where a previous save game would be loaded.");
                    continue;
                } else if (option2.equals("1")){
                    isTwoPlayerGame = false;
                } else if (option2.equals("m")){
                    p2 = new HumanPlayer(name2, new ManualShipFactory());
                } else if (option2.equals("a")){
                    p1 = new HumanPlayer(name1, new AutoShipFactory());
                }
                break;
            } else {
                System.out.println("Invalid selection. Please input either " + option1 + " or " + option2 + ".");
            }
        }
    }
}