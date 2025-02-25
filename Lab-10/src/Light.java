public class Light extends PoweredDevice {
    int intensity;
    String color;
    private static final int DEFAULT_DAY_INTENSITY = 200;
    private static final int DEFAULT_NIGHT_INTENSITY = 50;


    public Light() {
        super();
        this.intensity = DEFAULT_DAY_INTENSITY;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
        updatePowerConsumption();
    }

    public int getIntensity() {
        return intensity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    private void updatePowerConsumption() {
        setPowerConsumption(intensity * 0.5);
    }

    public void setDayMode() {
        setIntensity(DEFAULT_DAY_INTENSITY);
    }

    public void setNightMode() {
        setIntensity(DEFAULT_NIGHT_INTENSITY);
    }
}