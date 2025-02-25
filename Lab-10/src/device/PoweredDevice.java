package device;

public abstract class PoweredDevice implements Device {
    protected boolean isOn;
    protected String location;
    protected double powerConsumption;

    public PoweredDevice() {
        this.isOn = false;
        this.powerConsumption = 0.0;
    }

    @Override
    public void turnOn() {
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    protected void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}