public class TBlock extends AbstractBlock {
    public TBlock() {
        super('T');
    }

    @Override
    protected void initializeShape() {
        shape = new char[][] {
            {'*', '*', '*'},
            {' ', '*', ' '},
            {' ', '*', ' '}
        };
    }
}