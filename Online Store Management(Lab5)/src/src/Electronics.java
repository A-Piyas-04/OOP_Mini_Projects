package src;

public  class Electronics extends Product{
    public Electronics(String productName, int stockQuantity, double unitPrice) {
        super(productName, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return (unitPrice*1.15);
    }
}
