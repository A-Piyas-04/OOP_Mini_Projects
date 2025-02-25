abstract class PoweredDevice extends AbstractDevice {
    double powerConsumption;

    public PoweredDevice() {
        super();
        this.powerConsumption = 0.0;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    protected void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}