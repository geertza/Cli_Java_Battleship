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
                    return new ShotResult(ShotOutcome.SUNK, cd);
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
}
