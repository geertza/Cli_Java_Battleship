public class Player {
    private String name;
    private TargetGrid tg = new TargetGrid();
    private OceanGrid og = new OceanGrid();
    private ShipFactory sf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShipFactory(ShipFactory sf) {
        this.sf = sf;
    }

    public TargetGrid getTargetGrid() {
        return tg;
    }

    public OceanGrid getOceanGrid() {
        return og;
    }

    public ShipFactory getShipFactory() {
        return sf;
    }
}
