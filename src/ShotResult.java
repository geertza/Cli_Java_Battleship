public enum ShotResult {
    HIT,
    MISS,
    SUNK;

    private String shipName = null;
    private Coordinate shot = null;

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
