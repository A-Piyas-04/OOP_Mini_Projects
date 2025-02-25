package device.powered;

import device.PoweredDevice;

public class AirConditioner extends PoweredDevice {
    private double temperature;
    private String fanSpeed;
    private static final double MIN_TEMP = 18.0;
    private static final double MAX_TEMP = 25.0;
    private static final String[] FAN_SPEEDS = {"LOW", "HIGH"};

    public AirConditioner() {
        super();
        this.temperature = 22.0; // Default temperature
        this.fanSpeed = FAN_SPEEDS[0]; // Default to LOW
    }

    public void setTemperature(double temperature) {
        if (temperature < MIN_TEMP || temperature > MAX_TEMP) {
            throw new IllegalArgumentException("Temperature must be between " + MIN_TEMP + " and " + MAX_TEMP);
        }
        this.temperature = temperature;
        updatePowerConsumption();
    }

    public double getTemperature() {
        return temperature;
    }

    public void setFanSpeed(String speed) {
        if (!isValidFanSpeed(speed)) {
            throw new IllegalArgumentException("Invalid fan speed. Must be either LOW or HIGH");
        }
        this.fanSpeed = speed;
        updatePowerConsumption();
    }

    public String getFanSpeed() {
        return fanSpeed;
    }

    private boolean isValidFanSpeed(String speed) {
        for (String validSpeed : FAN_SPEEDS) {
            if (validSpeed.equals(speed)) {
                return true;
            }
        }
        return false;
    }

    private void updatePowerConsumption() {
        // Power consumption based on temperature difference from ambient (assumed 20°C)
        // and fan speed (HIGH consumes more power)
        double tempDiff = Math.abs(temperature - 20.0);
        double fanMultiplier = fanSpeed.equals("HIGH") ? 1.5 : 1.0;
        setPowerConsumption(tempDiff * 0.5 * fanMultiplier);
    }
}