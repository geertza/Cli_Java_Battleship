public class TargetGrid extends Grid {
    
    public void receiveShotResult(ShotResult sr) {
        Cell cell = getCellAtCoordinate(sr.getShot());
        ShotOutcome outcome = sr.getOutcome();
        switch (outcome) {
            case MISS:
                cell.setState(CellState.MISS);
                System.out.println("Miss at " + sr.getShot() + ".\n");
                break;
            case HIT:
                cell.setState(CellState.HIT);
                System.out.println("Hit at " + sr.getShot() + "!\n");
                break;
            case SUNK:
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
