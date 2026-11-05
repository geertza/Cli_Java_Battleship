
import java.util.ArrayList;

public class PlayGameCard {
    //playercard to handle state management 
    // uses the traget grid for hit and misses
    // uses playe p1 and p2 to create two cards.
    // Player information
    private String playerName;

    // Game statistics
    private int shotsFired;
    private ArrayList<String> hits;
    private ArrayList<String> misses;
    private ArrayList<String> ShipsRemaining;
    private ArrayList<String> EnemyShipsRemaining;
    private 

    // Game state
    private boolean isTurn;
    private boolean hasWon;

    // Constructor
    public PlayGameCard(String playerName) {
        this.playerName = playerName;
        this.shotsFired = 0;
        this.hits = new ArrayList<>();
        this.misses = new ArrayList<>();
        this.ShipsRemaining = 5;
        this.isTurn = false;
    }

    // Record a hit
    public void addHit(String location) {
        hits.add(location);
        shotsFired++;
    }

    // Record a miss
    public void addMiss(String location) {
        misses.add(location);
        shotsFired++;
    }

    // Update remaining ships
    public void setShipsRemaining(int ships) {
        if (ships >= 0 && ships <= 5) {
            shipsRemaining = ships;
        }
    }

    // Update player turn
    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    

    // Change player name
    public void setPlayerName(String name) {
        playerName = name;
    }

    // Getters
    public String getPlayerName() {
        return playerName;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public ArrayList<String> getHits() {
        return new ArrayList<>(hits);
    }

    public ArrayList<String> getMisses() {
        return new ArrayList<>(misses);
    }

    public int getShipsRemaining() {
        return shipsRemaining;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public boolean hasWon() {
        return hasWon;
    }

    // Print scorecard to CLI
    public void printScoreCard() {

        System.out.println("\n==============================");
        System.out.println("       BATTLESHIP SCORECARD");
        System.out.println("==============================");

        System.out.println("Player:         " + playerName);
        System.out.println("Shots Fired:    " + shotsFired);
        System.out.println("Hits:           " + hits.size());
        System.out.println("Misses:         " + misses.size());
        System.out.println("Ships Remaining:" + shipsRemaining);
        System.out.println("Player Turn:    " + isTurn);
        System.out.println("Has Won:        " + hasWon);

        System.out.println("\nHit Locations: " + hits);
        System.out.println("Miss Locations: " + misses);

        System.out.println("==============================\n");
    }
}
