import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TextInvoice implements Invoice {
    @Override
    public void generateInvoice(Order order) throws IOException {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "invoices/order_invoice_" + timestamp + ".txt";

        FileWriter writer = new FileWriter(filename);

        writer.write("=======) Yogurt Shop Invoice (=======\n\n");


        for (Yogurt yogurt : order.getYogurts()) {
            writer.write(yogurt.getName() + " - " + yogurt.getScoops() + " scoops: $" + String.format("%.2f", yogurt.getTotalPrice()) + "\n");
        }



        for (Toppings topping : order.getToppings()) {
            writer.write(topping.getName() + " - 1 time: $" + String.format("%.2f", topping.getPrice()) + "\n");
        }



        if (order.getContainerPrice() > 0) {
            writer.write("Glass Jar: $" + String.format("%.2f", order.getContainerPrice()) + "\n");
        }


        writer.write("\nSubtotal: $" + String.format("%.2f", order.calculateSubtotal()) + "\n");
        writer.write("Tax (8%): $" + String.format("%.2f", order.calculateTax()) + "\n");
        writer.write("Total Amount Due: $" + String.format("%.2f", order.calculateTotal()) + "\n");



        writer.close();
        System.out.println("Invoice saved as: " + filename);
    }
}
