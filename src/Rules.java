public class Rules {

    public static void printRules() {
        String border = "====================================================================";
        String divider = "--------------------------------------------------------------------";

        System.out.println(border);
        System.out.println("                       B A T T L E S H I P                          ");
        System.out.println("                           GAME RULES                               ");
        System.out.println(border);
        System.out.println();

        System.out.println("1. OBJECTIVE");
        System.out.println(divider);
        System.out.println("   Sink all 5 of your opponent's hidden ships before they sink yours.");
        System.out.println();

        System.out.println("2. FLEET COMPOSITION");
        System.out.println(divider);
        System.out.println("   Each player commands a fleet of 5 distinct ships:");
        System.out.printf("   %-20s | %s\n", "Ship Type", "Size (Grid Spaces)");
        System.out.printf("   %-20s | %s\n", "--------------------", "------------------");
        System.out.printf("   %-20s | 5 spaces\n", "Aircraft Carrier");
        System.out.printf("   %-20s | 4 spaces\n", "Battleship");
        System.out.printf("   %-20s | 3 spaces\n", "Cruiser");
        System.out.printf("   %-20s | 3 spaces\n", "Submarine");
        System.out.printf("   %-20s | 2 spaces\n", "Destroyer");
        System.out.println();

        System.out.println("3. SETUP PHASE");
        System.out.println(divider);
        System.out.println("   * Secretly deploy your fleet on a 10x10 'My Ships' grid.");
        System.out.println("   * Ships can be placed horizontally or vertically.");
        System.out.println("   * Ships CANNOT overlap and CANNOT hang off the grid boundaries.");
        System.out.println("   * Positions are locked once the battle begins.");
        System.out.println();

        System.out.println("4. COMBAT PHASE (Standard Turns)");
        System.out.println(divider);
        System.out.println("   * Players alternate taking turns.");
        System.out.println("   * On your turn, fire a SINGLE shot by calling a grid coordinate");
        System.out.println("     (e.g., 'A-5' or 'B-3').");
        System.out.println("   * Your opponent must announce if the shot is a 'HIT' or a 'MISS'.");
        System.out.println("   * If a shot lands on a space occupied by a ship, it is a HIT.");
        System.out.println("   * When every space of a ship has been hit, that ship is SUNK.");
        System.out.println();

        System.out.println("5. TRACKING THE BATTLE");
        System.out.println(divider);
        System.out.println("   * 'My Ships' Grid: Tracks your fleet and enemy hits/misses.");
        System.out.println("   * 'Tracking' Grid: Tracks your own shots targeting the enemy.");
        System.out.println("     - Mark Hits with an 'X'.");
        System.out.println("     - Mark Misses with an 'O' or a dot (·).");
        System.out.println();

        System.out.println("6. WINNING THE GAME");
        System.out.println(divider);
        System.out.println("   The first player to completely sink all 5 enemy ships wins!");
        System.out.println();
        System.out.println(border);
        System.out.println("\n\nPlease press enter to return to start menu.");
        ConsoleHelper.getInput("");
    }

    public static void main(String[] args) {
        printRules();
    }
}
