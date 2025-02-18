abstract class Yogurt {
    String name;
    double pricePerScoop;

    public Yogurt(String name, double pricePerScoop) {
        this.name = name;
        this.pricePerScoop = pricePerScoop;
    }

    public String getName() {
        return name;
    }
    public double getPricePerScoop() {
        return pricePerScoop;
    }
}
