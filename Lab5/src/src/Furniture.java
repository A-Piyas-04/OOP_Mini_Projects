package src;

public class Furniture extends Product{

    public Furniture(String productName, int stockQuantity, double unitPrice) {
        super(productName, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return (unitPrice*1.08);
    }
}
