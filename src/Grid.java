import java.util.ArrayList;
import java.util.List;

public class Grid {
    // Subclasses: OceanGrid, TargetGrid

    protected Cell[][] cells = new Cell[10][10];

    public Grid() {
        CreateCells();
    }
    public List<String> getShipStatusLines() {
    return new ArrayList<>();
}
    public List<String> getGridDisplayLines() {
        List<String> lines = new ArrayList<>();
        char[] rowLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        String border = "  " + ColorConsole.BLUE + "+---+---+---+---+---+---+---+---+---+---+";

        // Line 0: Column headers
        lines.add("    1   2   3   4   5   6   7   8   9  10  ");

        for (int r = 0; r < 10; r++) {
            // Add top border for the row
            lines.add(border);

            // Build the row string with cell states
            StringBuilder rowBuilder = new StringBuilder();
            rowBuilder.append(ColorConsole.RESET).append(rowLetters[r]).append(ColorConsole.BLUE).append(" |");

            for (int c = 0; c < 10; c++) {
                String color = ColorConsole.RESET;
                String symbol = " ";

                if (cells[r][c].getState() == CellState.HIT) {
                    color = ColorConsole.RED;
                    symbol = "X";
                } else if (cells[r][c].getState() == CellState.MISS) {
                    color = ColorConsole.RESET;
                    symbol = "O";
                } else if (cells[r][c].getState() == CellState.OCCUPIED) {
                    color = ColorConsole.GREY;
                    symbol = "#";
                } else if (cells[r][c].getState() == CellState.EMPTY) {
                    color = ColorConsole.RESET;
                    symbol = " ";
                }

                rowBuilder.append(" ").append(color).append(symbol).append(ColorConsole.BLUE).append(" |");
            }
            lines.add(rowBuilder.toString());
        }

        // Final bottom border with color reset
        lines.add(border + ColorConsole.RESET);

        return lines;
    }
    

    public void display() {
        List<String> gridLines = getGridDisplayLines();
        List<String> shipLines = getShipStatusLines();

    for (int i = 0; i < gridLines.size(); i++) {
        String right = i < shipLines.size() ? shipLines.get(i) : "";
        System.out.println(gridLines.get(i) + "   " + right);
    }
    }
    private void CreateCells() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                cells[r][c] = new Cell();
            }
        }
    }

    protected Cell getCellAtCoordinate(Coordinate coordinate) {
        return cells[coordinate.getRow()][coordinate.getColumn()];
    }
}