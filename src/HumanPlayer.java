public class HumanPlayer implements Player {
    private String name;
    private TargetGrid tg = new TargetGrid();
    private OceanGrid og = new OceanGrid();
    private ShipFactory sf;

    public HumanPlayer(String name, ShipFactory sf) {
        this.name = name;
        this.sf = sf;
    }

    public String getName() {
        return name;
    }

    public void placeShips() {
        if (sf == null) {
            throw new IllegalStateException("A ship factory must be set before placing ships.");
        }
        og.placeShips(sf.getShips());
    }

    public void receiveShotResult(ShotResult sr) {
        tg.receiveShotResult(sr);
    }

    public ShotResult receiveShot(Coordinate cd) {
        return og.receiveShot(cd);
    }

    public Coordinate takeShot() {
        while (true) {
            try {
                String coordStr = ConsoleHelper.getInput("\nEnter the coordinate you want to shoot at: ");
                Coordinate coord = new Coordinate(coordStr);
                if (tg.isValidShot(coord)) {
                    return coord;
                } else {
                   System.out.println("You have already shot at that coordinate, please enter a different coordinate to shoot at."); 
                }
            } catch (Exception e) {
                System.out.println("Please enter a proper coordinate, like E7 or A2 for example.");
            }
        }
    }

    public boolean shipsAreSunk() {
        for (Ship ship : og.getShips()) {
            if (ship.isSunk()) {
                continue;
            } else {return false;}
        }
        return true;
    }
}
