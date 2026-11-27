import java.util.ArrayList;
import java.util.List;

public class OceanGrid extends Grid {
    private List<Ship> ships;
    public ShotResult receiveShot(Coordinate cd) {
        Cell cell = getCellAtCoordinate(cd);
        CellState state = cell.getState();
        switch (state) {
            case CellState.OCCUPIED:
                cell.setState(CellState.HIT);
                Ship shipAtCell = cell.getShip();
                shipAtCell.addHit(cd);
                if (shipAtCell.isSunk()) {
                    ShotResult result = new ShotResult(ShotOutcome.SUNK, cd);
                    result.setShipName(shipAtCell.getName());
                    return result;
                }
                return new ShotResult(ShotOutcome.HIT, cd);
            default:
                cell.setState(CellState.MISS);
                return new ShotResult(ShotOutcome.MISS, cd);
        }
    }

    public void placeShips(List<Ship> ships) {
        this.ships = ships;
        for (Ship ship : ships) {
            for (Coordinate coord : ship.getCoordinates()) {
                Cell cell = getCellAtCoordinate(coord);
                cell.setState(CellState.OCCUPIED);
                cell.setShip(ship);
            }
        }
    }

    public boolean allShipsSunk() {
        if (ships == null || ships.isEmpty()) {
            return false;
        }

        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public List<Ship> getShips() {
        return ships;
    }
    //create a list of ships and get there issunk status and return it as a list of strings to be displayed in the console
    @Override
    public List<String> getShipStatusLines() {
    List<String> lines = new ArrayList<>();
    lines.add("Ships:");

    if (ships == null) {
        return lines;
    }

    for (Ship ship : ships) {
        String status;
        if (ship.isSunk()) {
            status = ColorConsole.RED + "SUNK" + ColorConsole.RESET;
        } else {
            status = ColorConsole.GREEN + "AFLOAT" + ColorConsole.RESET;
        }
        lines.add(String.format("  %-12s %s", ship.getName(), status));
    }
    return lines;
}
}
