import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class CSVInvoice implements Invoice {
    @Override
    public void generateInvoice(Order order) throws IOException {
        String fileName = "invoices/Invoice_" + System.currentTimeMillis() + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Item,Quantity,Price");

            for (Yogurt yogurt : order.yogurts)
                writer.println(yogurt.getName() + ",1," + yogurt.getPricePerScoop());

            for (Toppings topping : order.toppings)
                writer.println(topping.getName() + ",1," + topping.getPrice());

            writer.println("Container," + order.containerType + "," + order.containerPrice);
            writer.println("Subtotal,-," + order.calculateSubtotal());
            writer.println("Tax,-," + (order.calculateSubtotal() * 0.08));
            writer.println("Total Amount Due,-," + order.calculateTotal());

            System.out.println("Invoice saved as: " + fileName);
        }
    }
}
