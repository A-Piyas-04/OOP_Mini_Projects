public class TextInvoice implements Invoice{
    public void generateInvoice(Order order) {
        order.printOrderDetails();
    }
}
