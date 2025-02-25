import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CSVInvoice implements Invoice {
    @Override
    public void generateInvoice(Order order) throws IOException {
        // Generate unique filename using timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "invoices/order_invoice_" + timestamp + ".csv";

        FileWriter writer = new FileWriter(filename);

        writer.write("Ingredients,Amount,Price\n");



        for (Yogurt yogurt : order.getYogurts()) {
            writer.write(yogurt.getName() + "," + yogurt.getScoops() + "," + String.format("%.2f", yogurt.getTotalPrice()) + "\n");
        }


        for (Toppings topping : order.getToppings()) {
            writer.write(topping.getName() + ",1," + String.format("%.2f", topping.getPrice()) + "\n");
        }


        if (order.getContainerPrice() > 0) {
            writer.write("Glass Jar,-," + String.format("%.2f", order.getContainerPrice()) + "\n");
        }


        writer.write("Subtotal,-," + String.format("%.2f", order.calculateSubtotal()) + "\n");
        writer.write("Tax,-," + String.format("%.2f", order.calculateTax()) + "\n");
        writer.write("Total Amount Due,-," + String.format("%.2f", order.calculateTotal()) + "\n");

        writer.close();
        System.out.println("Invoice saved as: " + filename);
    }
}
