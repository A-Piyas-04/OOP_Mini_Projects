package src;

public abstract class Product {
    protected String productName;
    protected int stockQuantity;
    protected double unitPrice;
    public abstract double calculateTotalPrice();


    public Product(String productName, int stockQuantity, double unitPrice) {
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.unitPrice = unitPrice;
    }


    public String getProductName() {
        return productName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
