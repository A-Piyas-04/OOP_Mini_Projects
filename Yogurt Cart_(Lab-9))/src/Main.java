import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //invoices folder exists or not
        File invoiceFolder = new File("invoices");
        if (!invoiceFolder.exists()) {
            invoiceFolder.mkdir();
        }



        System.out.println("Choose your container: (paper/glass)");
        String containerType = scanner.nextLine();
        Order order = new Order(containerType);



        List<Yogurt> selectedYogurts = new ArrayList<>();
        System.out.println("Enter yogurt flavors (type 'done' to finish):");
        while (true) {
            System.out.print("Yogurt flavor: ");
            String yogurtName = scanner.nextLine();
            if (yogurtName.equalsIgnoreCase("done")) break;

            try {
                selectedYogurts.add(createYogurt(yogurtName));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid yogurt type! Try again.");
            }
        }

        //scoops........................
        for (Yogurt yogurt : selectedYogurts) {
            System.out.print("Enter number of scoops for " + yogurt.getName() + ": ");
            int scoops = scanner.nextInt();
            yogurt.setScoops(scoops);
            order.addYogurt(yogurt);
        }
        scanner.nextLine();




        System.out.println("Enter toppings (type 'done' to finish):");
        while (true) {
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) break;
            try {
                order.addToppings(createTopping(toppingName));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid topping type! Try again.");
            }
        }




        System.out.println("Choose invoice type: text/csv");
        String invoiceType = scanner.nextLine();
        Invoice invoice;
        try {
            invoice = createInvoice(invoiceType);
            invoice.generateInvoice(order);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }




    static Yogurt createYogurt(String type) {
        switch (type.toLowerCase()) {
            case "cookies and cream": return new CookiesAndCream();
            case "chocolate fudge": return new ChocolateFudge();
            case "pistachio delight": return new PistachioDelight();
            default: throw new IllegalArgumentException("Invalid yogurt type!");
        }
    }

    static Toppings createTopping(String type) {
        switch (type.toLowerCase()) {
            case "sprinkles": return new Sprinkles();
            case "mixed chopped nuts": return new MixedChoppedNuts();
            case "crushed gingerbread": return new CrushedGingerbread();
            case "fresh strawberries": return new FreshStrawberries();
            default: throw new IllegalArgumentException("Invalid topping type!");
        }
    }

    private static Invoice createInvoice(String type) {
        switch (type.toLowerCase()) {
            case "text": return new TextInvoice();
            case "csv": return new CSVInvoice();
            default: throw new IllegalArgumentException("Invalid invoice type!");
        }
    }
}
