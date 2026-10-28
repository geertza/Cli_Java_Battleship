public class Grid {
    // Subclasses: OceanGrid, TargetGrid

    protected Cell[][] cells = new Cell[10][10];

    public Grid() {
        CreateCells();
    }

    public void display() {
        String color = ColorConsole.RESET;
        String symbol = "";
        char[] rowLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.print("    1   2   3   4   5   6   7   8   9  10  ");

        for (int r = 0; r < 10; r++) {
            System.out.println("\n  "+ColorConsole.BLUE+"+---+---+---+---+---+---+---+---+---+---+   ");
            System.out.print(ColorConsole.RESET + rowLetters[r] + ColorConsole.BLUE+" |");
            for (int c = 0; c < 10; c++) {
                if (cells[r][c].getState() == CellState.HIT) {
                    color = ColorConsole.RED;
                    symbol = "X";
                }
                else if (cells[r][c].getState() == CellState.MISS) {
                    color = ColorConsole.RESET;
                    symbol = "O";
                }
                else if (cells[r][c].getState() == CellState.OCCUPIED) {
                    color = ColorConsole.GREY;
                    symbol = "#";
                }
                else if (cells[r][c].getState() == CellState.EMPTY) {
                    color = ColorConsole.RESET;
                    symbol =" ";
                }
                System.out.print(" "+color + symbol+ColorConsole.BLUE+" |");
            }
        }
        System.out.println("\n  "+ColorConsole.BLUE+"+---+---+---+---+---+---+---+---+---+---+   "+ ColorConsole.RESET);
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