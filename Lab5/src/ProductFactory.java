class ProductFactory{
    public static Product createProduct(String category, String name, int stockQuantity, double unitPrice) {
        switch (category.toLowerCase()) {
            case "electronics":
                return new Electronics(name, stockQuantity, unitPrice);
            case "clothing":
                return new Clothing(name, stockQuantity, unitPrice);
            case "furniture":
                return new Furniture(name, stockQuantity, unitPrice);
            default:
                throw new IllegalArgumentException("Unknown Product Category");
        }
    }
}

