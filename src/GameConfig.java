public class GameConfig {
    private ConsoleHelper con = new ConsoleHelper();
    private Game game;
    private Player p1 = new HumanPlayer();
    private Player p2;

    public void start() {
        System.out.println("                Would you like to resume a previous save game or make a new game?");
        System.out.println("                                     (N)ew Game - (L)oad Game");

        GetSelection("n", "l");

        System.out.println("                Would you like to play a 2 player game or battle against the computer?");
        System.out.println("                                    2 (P)layer - (C)omputer");

        GetSelection("p", "c");

        System.out.println("                What is your name Player 1?");
        String name = con.getInput("");
        p1.setName(name);

        if (p2 instanceof HumanPlayer) {
            System.out.println("                What is your name Player 2?");
            String name2 = con.getInput("");
            p2.setName(name2);
        }

        System.out.printf("                \nHey %s, would you like to play with manual or automatic ship placement?\n", p1.getName());
        System.out.println("                                    (M)anual - (A)utomatic");
        GetSelection("m", "a");

        if (p2 instanceof HumanPlayer) {
            System.out.printf("                \nHey %s, would you like to play with manual or automatic ship placement?\n", p2.getName());
            System.out.println("                                    (M)anual - (A)utomatic");
            GetSelection("a", "m"); // flip the order of options to make to get the selection for player 2
        }

        game = new Game(p1, p2);
        game.play();
    }

    private void GetSelection(String option1, String option2) {
        while(true){
            String selection = con.getInput("");
            selection = selection.toLowerCase();
            if (selection.equals(option1)){
                if (option1.equals("n")){
                    System.out.println("Starting a new game...");
                } else if (option1.equals("p")){
                    System.out.println("Starting a 2 player game...");
                    p2 = new HumanPlayer();
                } else if (option1.equals("m")){
                    System.out.println("Manual ship placement selected for player 1.");
                    p1.setShipFactory(new ManualShipFactory());
                } else if (option1.equals("a")){
                    System.out.println("Automatic ship placement selected for player 1.");
                    p2.setShipFactory(new AutoShipFactory());
                }
                break;
            }
            else if (selection.equals(option2)){
                if (option2.equals("l")){
                    System.out.println("This is where a previous save game would be loaded.");
                    continue;
                } else if (option2.equals("c")){
                    System.out.println("Starting a game against the computer...");
                    p2 = new AIPlayer();
                } else if (option2.equals("a")){
                    System.out.println("Automatic ship placement selected for player 1.");
                    p1.setShipFactory(new AutoShipFactory());
                } else if (option2.equals("m")){
                    System.out.println("Manual ship placement selected for player 2.");
                    p2.setShipFactory(new ManualShipFactory());
                }
                break;
            } else {
                System.out.println("Invalid selection. Please input either " + option1 + " or " + option2 + ".");
            }
        }
    }
}