class Yogurt {
    private String name;
    private double pricePerScoop;
    private int scoops;

    public Yogurt(String name, double pricePerScoop) {
        this.name = name;
        this.pricePerScoop = pricePerScoop;
        this.scoops = 0;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return scoops * pricePerScoop;
    }

    public int getScoops() {
        return scoops;
    }
}
