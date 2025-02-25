package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        
        ProductFactory productFactory = new ProductFactory();
        
        products.add(productFactory.createProduct("electronics", "Acer Laptop", 10, 1000));
        products.add(productFactory.createProduct("electronics", "Lenovo Laptop", 10, 1000));
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));
        products.add(productFactory.createProduct("furniture", "Sofa", 5, 500));
        products.add(productFactory.createProduct("electronics", "Smartphone", 30, 700));
        products.add(productFactory.createProduct("electronics", "Smartphone", 37, 700));
        products.add(productFactory.createProduct("furniture", "Table", 8, 300));


        OrderManager.sortProducts(products);



        for(Product product : products) {
            System.out.println(product.getProductName()+ "        Total Price: " + product.calculateTotalPrice() + "        Stock: " + product.getStockQuantity());
        }
    }
}