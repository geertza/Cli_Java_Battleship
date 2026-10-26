import java.util.List;

public class OceanGrid extends Grid {
    private List<Ship> ships;

    public ShotResult receiveShot(Coordinate cd) {
        Cell cell = getCellAtCoordinate(cd);
        CellState state = cell.getState();
        switch (state) {
            case CellState.EMPTY:
                cell.setState(CellState.MISS);
                return ShotResult.MISS;
            case CellState.OCCUPIED:
                cell.setState(CellState.HIT);
                Ship shipAtCell = cell.getShip();
                shipAtCell.addHit(cd);
                if (shipAtCell.isSunk()) {
                    return ShotResult.SUNK;
                }
                return ShotResult.HIT;
            default:
                return ShotResult.MISS;
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
