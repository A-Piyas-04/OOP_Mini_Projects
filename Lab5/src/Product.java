abstract class Product {
    protected String name;
    protected int stockQuantity;
    protected double unitPrice;

    public abstract double calculateTotalPrice();
}
