public interface Block {
    /**
     * Get the current shape of the block
     * @return 2D array representing the block's shape
     */
    char[][] getShape();

    /**
     * Rotate the block clockwise
     * @param times number of 90-degree rotations
     */
    void rotate(int times);

    /**
     * Get the type of the block (L, O, I, J, T)
     * @return character representing block type
     */
    char getType();

    /**
     * Get the current position of the block
     * @return array containing [row, col] of the top-left position
     */
    int[] getPosition();

    /**
     * Set the position of the block
     * @param row row coordinate
     * @param col column coordinate
     */
    void setPosition(int row, int col);
}