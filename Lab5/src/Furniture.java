public class Furniture extends Product{

    public Furniture(String name, int stockQuantity, double unitPrice) {
        super(name, stockQuantity, unitPrice);
    }

    @Override
    public double calculateTotalPrice() {
        return 0;
    }
}
