import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    
    // SRP: Hold a row and column of a specific cell.

    private int row;
    private int column;

    /*
        Interally, a coordinate holds 2 zero based numbers
        for the row and column (0-9) */

    public Coordinate(String position) throws Exception {
        String normalizedPosition = position.toLowerCase();
        this.row = rowFromString(normalizedPosition);
        this.column = columnFromString(normalizedPosition);
    }

    public Coordinate(int row, int column) throws Exception{
        if(row < 0 || row > 9) {
            throw new Exception("Invalid Row for coordinate");
        }
        if(column < 0 || column > 9) {
            throw new Exception("Invalid Column for coordinate");
        }
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        char firstChar = (char)(row + 97); // ascii for little a is 97
        String result = Character.toString(firstChar) + Integer.toString(column + 1);
        return result.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check and type check
        if (o == null || getClass() != o.getClass())
            return false;
        // cast
        Coordinate c = (Coordinate) o;
        // field comparison
        return Objects.equals(row, c.row)
                && Objects.equals(column, c.column);
    }   

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    private int rowFromString(String position) throws Exception {
        char firstChar = position.charAt(0);
        int asciiValue = (int)firstChar;
        int row = asciiValue - 97; // ascii of 'a' is 97
        if(row < 0 || row > 9) {
            throw new Exception("Invalid Row for coordinate");
        }
        return row;
    }

    private int columnFromString(String position) throws Exception {
        String columnPortion = position.substring(1);
        int column = Integer.parseInt(columnPortion) - 1; // -1 to convert human to computer number
        if(column < 0 || column > 9) {
            throw new Exception("Invalid Column for coordinate");
        }
        return column;
    }

    public List<Coordinate> coordsInDirection(int numOfCoords, Direction direction) throws Exception {
        List<Coordinate> coords = new ArrayList<Coordinate>();

        for (int x = 0; x < numOfCoords; x++) {
            switch (direction) {
                case NORTH:
                    coords.add(new Coordinate(row - x, column));
                    break;
                case EAST:
                    coords.add(new Coordinate(row, column + x));
                    break;
                case SOUTH:
                    coords.add(new Coordinate(row + x, column));
                    break;
                case WEST:
                    coords.add(new Coordinate(row, column - x));
                    break;
            }
        }
        return coords;
    }
}
