import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TargetGrid extends Grid {
    private final List<Ship> fleet = ShipFactory.createFleet();
    private final Set<String> sunkShipNames = new HashSet<>();
    
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
                if (sr.getShipName() == null) {
                    throw new IllegalArgumentException("A sunk result must include the ship name.");
                }
                cell.setState(CellState.HIT);
                sunkShipNames.add(sr.getShipName());
                System.out.println(sr.getShipName() + " sunk at " + sr.getShot() + "!\n");
                break;
        }
    }

    @Override
    public List<String> getShipStatusLines() {
        List<String> lines = new ArrayList<>();
        lines.add("Opponent Ships:");

        for (Ship ship : fleet) {
            boolean isSunk = sunkShipNames.contains(ship.getName());
            String status = isSunk
                ? ColorConsole.RED + "SUNK" + ColorConsole.RESET
                : ColorConsole.GREY + "UNKNOWN" + ColorConsole.RESET;
            lines.add(String.format("  %-12s | %s", ship.getName(), status));
        }

        return lines;
    }

    public Boolean isValidShot(Coordinate cd) {
        Cell cell = getCellAtCoordinate(cd);
        return cell.getState() == CellState.EMPTY;
    }
}
