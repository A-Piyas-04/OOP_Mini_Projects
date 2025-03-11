public abstract class AbstractBlock implements Block {
    protected char[][] shape;
    protected char type;
    protected int[] position;

    public AbstractBlock(char type) {
        this.type = type;
        this.position = new int[]{0, 0};
        initializeShape();
    }

    protected abstract void initializeShape();

    @Override
    public char[][] getShape() {
        return shape;
    }

    @Override
    public void rotate(int times) {
        times = times % 4;
        for (int t = 0; t < times; t++) {
            rotateOnce();
        }
    }

    private void rotateOnce() {
        int n = shape.length;
        char[][] rotated = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n-1-i] = shape[i][j];
            }
        }
        
        shape = rotated;
    }

    @Override
    public char getType() {
        return type;
    }

    @Override
    public int[] getPosition() {
        return position;
    }

    @Override
    public void setPosition(int row, int col) {
        position[0] = row;
        position[1] = col;
    }
}