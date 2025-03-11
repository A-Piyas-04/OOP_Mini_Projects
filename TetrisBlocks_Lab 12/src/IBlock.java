public class IBlock extends AbstractBlock {
    public IBlock() {
        super('I');
    }

    @Override
    protected void initializeShape() {
        shape = new char[][] {
            {'*', ' ', ' '},
            {'*', ' ', ' '},
            {'*', ' ', ' '}
        };
    }
}