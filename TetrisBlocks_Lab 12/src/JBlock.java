public class JBlock extends AbstractBlock {
    public JBlock() {
        super('J');
    }

    @Override
    protected void initializeShape() {
        shape = new char[][] {
            {' ', '*', ' '},
            {' ', '*', ' '},
            {'*', '*', ' '}
        };
    }
}