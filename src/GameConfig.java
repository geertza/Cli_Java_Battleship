public class GameConfig {
    
    private Game game;
    private Player p1;
    private Player p2;

    public void start() {
        
    }

    public void load() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("This is a placeholder for loading a saved game.\n\nPlease press enter to return to previous screen");

        ConsoleHelper.getInput("");
    }
}
