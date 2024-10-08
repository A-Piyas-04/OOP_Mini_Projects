import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(ProductFactory.createProduct("electronics", "Acer Laptop", 10, 1000));
        products.add(ProductFactory.createProduct("electronics", "Lenovo Laptop", 10, 1000));
        products.add(ProductFactory.createProduct("clothing", "T-shirt", 50, 20));
        products.add(ProductFactory.createProduct("furniture", "Sofa", 5, 500));
        products.add(ProductFactory.createProduct("electronics", "Smartphone", 30, 700));
        products.add(ProductFactory.createProduct("electronics", "Smartphone", 37, 700));
        products.add(ProductFactory.createProduct("furniture", "Table", 8, 300));


        OrderManager.sortProducts(products);



        for(Product product : products) {
            System.out.println(product.getProductName()+ "        Total Price: " + product.calculateTotalPrice() + "        Stock: " + product.getStockQuantity());
        }
    }
}