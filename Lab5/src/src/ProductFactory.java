package src;

public class ProductFactory{
    public Product createProduct(String category, String productName, int stockQuantity, double unitPrice) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new Electronics(productName,stockQuantity,unitPrice);
            case "clothing":
                return new Clothing(productName,stockQuantity,unitPrice);
            case "furniture":
                return new Furniture(productName,stockQuantity,unitPrice);
            default:
                throw new IllegalArgumentException("Unknown src.Product Category");
        }
    }
}

