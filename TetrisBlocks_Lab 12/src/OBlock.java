public class OBlock extends AbstractBlock {
    public OBlock() {
        super('O');
    }

    @Override
    protected void initializeShape() {
        shape = new char[][] {
            {'*', '*', '*'},
            {'*', '*', '*'},
            {'*', '*', '*'}
        };
    }
}