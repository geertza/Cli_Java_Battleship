public class Grid {
    // Subclasses: OceanGrid, TargetGrid

    protected Cell[][] cells = new Cell[10][10];

    public Grid() {
        CreateCells();
    }

    public void display() {
        char[] rowLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L'};
        System.out.print("    1   2   3   4   5   6   7   8   9  10  ");

        for (int r = 0; r < 10; r++) {
            System.out.println("\n  +---+---+---+---+---+---+---+---+---+---+   ");
            System.out.print(rowLetters[r] + " |");
            for (int c = 0; c < 10; c++) {
                if (cells[r][c].getState() == CellState.HIT) {
                    System.out.print(" X |");
                }
                else if (cells[r][c].getState() == CellState.MISS) {
                    System.out.print(" O |");
                }
                else if (cells[r][c].getState() == CellState.OCCUPIED) {
                    System.out.print(" # |");
                }
                else if (cells[r][c].getState() == CellState.EMPTY) {
                    System.out.print("   |");
                }
            }
        }
        System.out.println("\n  +---+---+---+---+---+---+---+---+---+---+   ");
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