import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ShipFactory {
    protected List<Ship> ships = new ArrayList<Ship>();
    

    public List<Ship> getShips() {
        List<Ship> initShips = List.of(
        new Ship("Carrier", 5),
        new Ship("Battleship", 4),
        new Ship("Cruiser", 3),
        new Ship("Submarine", 3),
        new Ship("Destroyer", 2)
        );

        Set<Coordinate> existingCoords = new HashSet<Coordinate>();

        for (Ship ship : initShips) {
            while (true) {
                try {
                    Coordinate start = getStartCoordinate(ship);
                    Direction dir = getStartDirection(ship);
                    List<Coordinate> coords = start.coordsInDirection(ship.getLength(), dir);
                    if (coordinatesOverlapExistingCoordinates(coords, existingCoords)) {
                        displayErrorMessage(String.format("Ship is overlapping existing ships, please enter a differant Coordinate or Direction for your %s.", ship.getName()));
                        continue;
                    }
                    ship.setCoordinates(coords);
                    existingCoords.addAll(coords);
                    ships.add(ship);
                    break;
                } catch (Exception e) {
                    displayErrorMessage(String.format("Ship went off of the grid, please enter a differant Coordinate or Direction for your %s.", ship.getName()));
                    continue;
                }
            }
        }

        return ships;
    }

    protected abstract Coordinate getStartCoordinate(Ship ship);

    protected abstract Direction getStartDirection(Ship ship);

    protected abstract void displayErrorMessage(String reason);

    protected Boolean coordinatesOverlapExistingCoordinates(List<Coordinate> coords, Set<Coordinate> existingCoords) {
        for (Coordinate coord : coords) {
            if (existingCoords.contains(coord)) {
                return true;
            }
        }
        return false;
    }
}
