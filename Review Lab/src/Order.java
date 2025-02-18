import java.util.ArrayList;
import java.util.List;

class Order {
    List<Yogurt> yogurts;
    List<Toppings> toppings;
    String containerType;
    private static final double TAX_RATE = 0.08;
    double containerPrice;

    public Order(String containerType) {
        this.yogurts = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.containerType = containerType;
        this.containerPrice = containerType.equalsIgnoreCase("glass") ? 5.00 : 0.00;
    }

    public void addYogurt(Yogurt yogurt){
         yogurts.add(yogurt);
    }

    public void addToppings(Toppings topping){
        toppings.add(topping);
    }

    public double calculateSubtotal() {
        double total = containerPrice;
        for (Yogurt yogurt : yogurts) total += yogurt.getTotalPrice();
        for (Toppings Toppings : toppings) total += Toppings.getPrice();
        return total;
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        return subtotal + (subtotal * TAX_RATE);
    }

    public void printOrderDetails() {
        System.out.println("Yogurt Shop Invoice");
        for (Yogurt yogurt : yogurts)
            System.out.println(yogurt.getName() + " - 1 scoop : $" + yogurt.getTotalPrice());

        for (Toppings Toppings : toppings)
            System.out.println(Toppings.getName() + " - 1 time : $" + Toppings.getPrice());

        System.out.println("Container Type: " + containerType + " - $" + containerPrice);
        System.out.println("Subtotal: $" + calculateSubtotal());
        System.out.println("Tax : $" + (calculateSubtotal() * TAX_RATE));
        System.out.println("Total Amount Due: $" + calculateTotal());
    }
}
