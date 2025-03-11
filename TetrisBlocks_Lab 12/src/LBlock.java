public class LBlock extends AbstractBlock {
    public LBlock() {
        super('L');
    }

    @Override
    protected void initializeShape() {
        shape = new char[][] {
            {'*', ' ', ' '},
            {'*', ' ', ' '},
            {'*', '*', ' '}
        };
    }
}