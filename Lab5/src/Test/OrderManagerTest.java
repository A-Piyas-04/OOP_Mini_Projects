package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import src.OrderManager;
import src.Product;
import src.ProductFactory;

import java.util.ArrayList;
import java.util.List;



public class OrderManagerTest {
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


    }
    @Test
    public void testProductTotalPriceCalculation() {
        ProductFactory productFactory = new ProductFactory();
        Product acerLaptop = productFactory.createProduct("electronics", "Acer Laptop", 10, 1000);
        assertEquals(1150.0, acerLaptop.calculateTotalPrice(), 0.01);

        Product tShirt = productFactory.createProduct("clothing", "T-shirt", 50, 20);
        assertEquals(22.0, tShirt.calculateTotalPrice(), 0.01);
    }
}
