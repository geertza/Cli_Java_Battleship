public class App {
    public static void main(String[] args) throws Exception {
        new StartMenu().display();
    }

    public static void quit() {
        System.exit(0);
        GameConfig gameConfig = new GameConfig();
        gameConfig.start();
    }
}
