class CSVInvoice implements Invoice {
    @Override
    public void generateInvoice(Order order) {
        System.out.println("Ingredients, Amount, Price");
        for (Yogurt yogurt : order.yogurts)
            System.out.println(yogurt.getName() + ",1," + yogurt.getPricePerScoop());

        for (Toppings topping : order.toppings)
            System.out.println(topping.getName() + ",1," + topping.getPrice());

        System.out.println("Container," + order.containerType + "," + order.containerPrice);
        System.out.println("Subtotal,-," + order.calculateSubtotal());
        System.out.println("Tax,-," + (order.calculateSubtotal() * 0.08));
        System.out.println("Total Amount Due,-," + order.calculateTotal());
    }
}
