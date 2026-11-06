public class AutoShipFactory extends ShipFactory {

    @Override 
    protected Coordinate getStartCoordinate(Ship ship) {
        return Coordinate.randomCoordinate();
    }

    @Override
    protected Direction getStartDirection(Ship ship){
        return Direction.randomDirection();
    }

    @Override
    protected void displayErrorMessage(String reason) {
    // Dont display errors for automatic
}
}
