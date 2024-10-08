package src;

public class Clothing extends Product{
    public Clothing(String productName, int stockQuantity, double unitPrice) {
        super(productName, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return (unitPrice*1.1);
    }
}
