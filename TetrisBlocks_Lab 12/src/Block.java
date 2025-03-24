public interface Block {
    char[][] getShape();

    void rotate(int times);

    char getType();

    int[] getPosition();

    void setPosition(int row, int col);
}