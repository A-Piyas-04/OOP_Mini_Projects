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


    }
    @Test
    public void testProductTotalPriceCalculation() {
        ProductFactory productFactory = new ProductFactory();
        Product acerLaptop = productFactory.createProduct("electronics", "Acer Laptop", 10, 1000);
        assertEquals(1150.0, acerLaptop.calculateTotalPrice(), 0.01);

        Product tShirt = productFactory.createProduct("clothing", "T-shirt", 50, 20);
        assertEquals(22.0, tShirt.calculateTotalPrice(), 0.01);
    }


    @Test
    public void testSortByTotalPrice() {
        List<Product> products = new ArrayList<>();
        ProductFactory productFactory=new ProductFactory();
        products.add(productFactory.createProduct("electronics", "Acer Laptop", 10, 1000));
        products.add(productFactory.createProduct("electronics", "Lenovo Laptop", 10, 1000));
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));
        products.add(productFactory.createProduct("furniture", "Sofa", 5, 500));
        products.add(productFactory.createProduct("electronics", "Smartphone", 30, 700));
        products.add(productFactory.createProduct("electronics", "Smartphone", 37, 700));
        products.add(productFactory.createProduct("furniture", "Table", 8, 300));


        OrderManager.sortProducts(products);
        assertEquals("T-shirt", products.get(0).getProductName());
        assertEquals("Table", products.get(1).getProductName());
        assertEquals("Sofa", products.get(2).getProductName());
    }


    @Test
    public void testSortByNameWhenPricesEqual() {
        List<Product> products = new ArrayList<>();
        ProductFactory productFactory=new ProductFactory();
        products.add(productFactory.createProduct("electronics", "Acer Laptop", 10, 1000));
        products.add(productFactory.createProduct("electronics", "Lenovo Laptop", 10, 1000));
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));
        products.add(productFactory.createProduct("furniture", "Sofa", 5, 500));
        products.add(productFactory.createProduct("electronics", "Smartphone", 30, 700));
        products.add(productFactory.createProduct("electronics", "Smartphone", 37, 700));
        products.add(productFactory.createProduct("furniture", "Table", 8, 300));

        OrderManager.sortProducts(products);
        assertEquals("Acer Laptop", products.get(5).getProductName());
        assertEquals("Lenovo Laptop", products.get(6).getProductName());
    }



    @Test
    public void testTotalPriceCalculationForClothing() {
        List<Product> products = new ArrayList<>();
        ProductFactory productFactory=new ProductFactory();

        products.add(productFactory.createProduct("electronics", "Acer Laptop", 10, 1000));
        products.add(productFactory.createProduct("electronics", "Lenovo Laptop", 10, 1000));
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));
        products.add(productFactory.createProduct("furniture", "Sofa", 5, 500));
        products.add(productFactory.createProduct("electronics", "Smartphone", 30, 700));
        products.add(productFactory.createProduct("electronics", "Smartphone", 37, 700));
        products.add(productFactory.createProduct("furniture", "Table", 8, 300));

        OrderManager.sortProducts(products);


        Product tShirt = productFactory.createProduct("clothing", "T-shirt", 50, 20);
        assertEquals(22.0, tShirt.calculateTotalPrice(), 0.01);  // 20 + 10% tax
    }


    @Test
    public void testSortingByTotalPrice() {
        List<Product> products = new ArrayList<>();
        ProductFactory productFactory=new ProductFactory();

        products.add(productFactory.createProduct("electronics", "Acer Laptop", 10, 1000));  // 1150
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));            // 22
        products.add(productFactory.createProduct("furniture", "Sofa", 5, 500));              // 540

        OrderManager.sortProducts(products);

        assertEquals("T-shirt", products.get(0).getProductName());      // Lowest price
        assertEquals("Sofa", products.get(1).getProductName());         // Middle price
        assertEquals("Acer Laptop", products.get(2).getProductName());  // Highest price
    }


    @Test
    public void testSortingWithMixedCategories() {

        List<Product> products = new ArrayList<>();
        ProductFactory productFactory=new ProductFactory();


        products.add(productFactory.createProduct("electronics", "Smartphone", 30, 700)); // 805
        products.add(productFactory.createProduct("furniture", "Table", 8, 300));         // 324
        products.add(productFactory.createProduct("clothing", "T-shirt", 50, 20));        // 22

        OrderManager.sortProducts(products);

        assertEquals("T-shirt", products.get(0).getProductName());  // Lowest price
        assertEquals("Table", products.get(1).getProductName());    // Middle price
        assertEquals("Smartphone", products.get(2).getProductName()); // Highest price
    }






}
