public class Board {
    private static final int ROWS = 20;
    private static final int COLS = 10;
    private char[][] grid;

    public Board() {
        grid = new char[ROWS][COLS];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public boolean canPlaceBlock(Block block, int row, int col) {
        char[][] shape = block.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == '*') {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS || grid[newRow][newCol] != ' ') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void placeBlock(Block block) {
        int[] pos = block.getPosition();
        char[][] shape = block.getShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == '*') {
                    grid[pos[0] + i][pos[1] + j] = block.getType();
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(grid[i][j] == ' ' ? "." : grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void clear() {
        initializeGrid();
    }
}