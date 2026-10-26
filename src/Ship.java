import java.util.List;
import java.util.ArrayList;
public class Ship {

    private String name;
    private int length;
    private List<Coordinate> coordinates;
    private List<Coordinate> hits = new ArrayList<Coordinate>();

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public boolean isSunk() {
        return hits.size() == length;
    }

    public void addHit(Coordinate coordinate) {
        hits.add(coordinate);
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
}
