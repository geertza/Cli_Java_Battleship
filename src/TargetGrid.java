public class TargetGrid extends Grid {
    
    public void receiveShotResult(ShotResult sr) {
        Cell cell = getCellAtCoordinate(sr.getShot());
        switch (sr) {
            case ShotResult.MISS:
                cell.setState(CellState.MISS);
                System.out.println("Miss at " + sr.getShot() + ".\n");
                break;
            case ShotResult.HIT:
                cell.setState(CellState.HIT);
                System.out.println("Hit at " + sr.getShot() + "!\n");
                break;
            case ShotResult.SUNK:
                cell.setState(CellState.HIT);
                System.out.println(sr.getShipName() + " sunk at " + sr.getShot() + "!\n");
                break;
        }
    }

    public Boolean isValidShot(Coordinate cd) {
        Cell cell = getCellAtCoordinate(cd);
        return cell.getState() == CellState.EMPTY;
    }
}
