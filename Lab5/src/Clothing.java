public class Clothing extends Product{
    public Clothing(String name, int stockQuantity, double unitPrice) {
        super(name, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return 0;
    }
}
