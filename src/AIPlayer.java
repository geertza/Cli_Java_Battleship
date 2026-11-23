import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AIPlayer implements Player {
    private final OceanGrid oceanGrid = new OceanGrid();
    private final List<Coordinate> remainingShots = new ArrayList<>();
    private final Random random = new Random();

    public String getName() {
        return "Computer";
    }

    public Coordinate takeShot() {
        if (remainingShots.isEmpty()) {
            throw new IllegalStateException("The AI has no untried coordinates left.");
        }
        return remainingShots.remove(remainingShots.size() - 1);
    }

    public ShotResult receiveShot(Coordinate shot) {
        return oceanGrid.receiveShot(shot);
    }

    public void receiveShotResult(ShotResult shotResult) {
        // This AI chooses shots randomly and does not use outcomes to guide later shots.
    }

    public boolean shipsAreSunk() {
        return oceanGrid.allShipsSunk();
    }

    public void placeShips() {
        oceanGrid.placeShips(new AutoShipFactory().getShips());
        resetShots();
    }

    private void resetShots() {
        remainingShots.clear();
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                try {
                    remainingShots.add(new Coordinate(row, column));
                } catch (Exception exception) {
                    throw new IllegalStateException("Could not initialize AI shot coordinates.", exception);
                }
            }
        }
        Collections.shuffle(remainingShots, random);
    }
}
