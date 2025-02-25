public class HumiditySensor extends SensoryDevice {
    private double humidityLevel;
    private String measurementUnit;
    private static final String[] VALID_UNITS = {"percentage", "grams per cubic metre"};

    public HumiditySensor() {
        super();
        this.humidityLevel = 0.0;
        this.measurementUnit = VALID_UNITS[0];
    }

    public void setMeasurementUnit(String unit) {
        if (!isValidUnit(unit)) {
            throw new IllegalArgumentException("Invalid measurement unit. Must be either 'percentage' or 'grams per cubic metre'");
        }
        this.measurementUnit = unit;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    private boolean isValidUnit(String unit) {
        for (String validUnit : VALID_UNITS) {
            if (validUnit.equals(unit)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void processData() {

        double notificationThreshold = 70.0 * (11 - sensitivity) / 10.0;
        if (humidityLevel > notificationThreshold) {
            sendNotification("High humidity level detected: " + 
                String.format("%.2f %s", humidityLevel, 
                measurementUnit.equals("percentage") ? "%" : "g/m³"));
        }
    }


    public void updateHumidityLevel(double level) {
        this.humidityLevel = level;
        if (isOn()) {
            processData();
        }
    }

    public double getHumidityLevel() {
        return humidityLevel;
    }

    @Override
    protected void sendNotification(String message) {
        if (notificationEnabled) {

            System.out.println("HumiditySensor Notification: " + message);
        }
    }
}