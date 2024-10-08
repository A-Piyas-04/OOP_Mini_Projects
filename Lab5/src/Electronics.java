public  class Electronics extends Product{

    public Electronics(String name, int stockQuantity, double unitPrice) {
        super(name, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return 0;
    }
}
