public class ManualShipFactory extends ShipFactory {   
    @Override
    protected Coordinate getStartCoordinate(Ship ship) {
        while(true){
            String selection = ConsoleHelper.getInput(String.format("Enter the start coordinate you want for your %s (%s long) ",ship.getName(),ship.getLength()));
            try {
                return new Coordinate(selection);
            } catch (Exception e) {
                System.out.println("Invalid selection, please enter a proper coordinate (Letter of row + number of column, like C6 for example)");
                continue;
            }
        }
    }

    @Override
    protected Direction getStartDirection(Ship ship) {
        System.out.println("Please enter the direction you would like your ship to be placed at.");
        System.out.println("(1) North  (2) East  (3) South  (4) West");
        while(true) {
            int selection = ConsoleHelper.getNumberBetween("(Enter a number between 1-4): ", 1, 4);
            switch(selection) {
                case 1:
                    return Direction.NORTH;
                case 2:
                    return Direction.EAST;
                case 3:
                    return Direction.SOUTH;
                case 4:
                    return Direction.WEST;
                default:
                    System.out.println("Please enter a valid value between 1-4.");
                    continue;
            }
        }
    }

    @Override
    protected void displayErrorMessage(String reason) {
        System.out.println(reason + "\n");
    }
    private final OceanGrid oceanGrid;

    public ManualShipFactory(OceanGrid oceanGrid) {
        this.oceanGrid = oceanGrid;
    }

    @Override
    protected void onShipPlaced(Ship ship) {
        oceanGrid.placeShips(ships);
        oceanGrid.display();
    }


}
