import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Yogurt> yogurts;
    private List<Toppings> toppings;
    private String containerType;
    private double containerPrice;

    public Order(String containerType) {
        this.yogurts = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.containerType = containerType;
        this.containerPrice = containerType.equalsIgnoreCase("glass") ? 5.00 : 0.00;
    }

    public void addYogurt(Yogurt yogurt) {
        yogurts.add(yogurt);
    }

    public void addToppings(Toppings topping) {
        toppings.add(topping);
    }

    public List<Yogurt> getYogurts() {
        return yogurts;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public double getContainerPrice() {
        return containerPrice;
    }

    public double calculateSubtotal() {
        double subtotal = containerPrice;
        for (Yogurt yogurt : yogurts) {
            subtotal += yogurt.getTotalPrice(); // Multiple scoops handled correctly
        }
        for (Toppings topping : toppings) {
            subtotal += topping.getPrice();
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * 0.08;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
}
