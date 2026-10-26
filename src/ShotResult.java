public class ShotResult {

    private String shipName = null;
    private Coordinate shot = null;
    private ShotOutcome outcome;

    public ShotResult(ShotOutcome outcome, Coordinate shot) {
        this.outcome = outcome;
        this.shot = shot;
    }

    public ShotOutcome getOutcome() {
        return outcome;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Coordinate getShot() {
        return shot;
    }

    public void setShot(Coordinate shot) {
        this.shot = shot;
    }
}
