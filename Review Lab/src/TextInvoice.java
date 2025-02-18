import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class TextInvoice implements Invoice {
    @Override
    public void generateInvoice(Order order) throws IOException {
        String fileName = "invoices/Invoice_" + System.currentTimeMillis() + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("========) Yogurt Shop Invoice (========\n");

            for (Yogurt yogurt : order.yogurts)
                writer.println(yogurt.getName() + " - 1 scoop: $" + yogurt.getTotalPrice());

            for (Toppings topping : order.toppings)
                writer.println(topping.getName() + " - 1 time: $" + topping.getPrice());

            writer.println("\nContainer Type: " + order.containerType + " - $" + order.containerPrice);
            writer.println("Subtotal: $" + order.calculateSubtotal());
            writer.println("Tax : $" + (order.calculateSubtotal() * 0.08));
            writer.println("Total Amount Due: $" + order.calculateTotal());

            System.out.println("Invoice saved as: " + fileName);
        }
    }
}

