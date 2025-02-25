public class Light extends PoweredDevice {
    private int intensity;
    private String color;
    private static final int DEFAULT_DAY_INTENSITY = 400;
    private static final int DEFAULT_NIGHT_INTENSITY = 150;
    private static final String DEFAULT_DAY_COLOR = "CoolWhite";
    private static final String DEFAULT_NIGHT_COLOR = "Amber";

    public Light() {
        super();
        this.intensity = DEFAULT_DAY_INTENSITY;
        this.color = DEFAULT_DAY_COLOR;
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
        setPowerConsumption(intensity * 0.1);
    }

    public void setDayMode() {
        setIntensity(DEFAULT_DAY_INTENSITY);
        setColor(DEFAULT_DAY_COLOR);
    }

    public void setNightMode() {
        setIntensity(DEFAULT_NIGHT_INTENSITY);
        setColor(DEFAULT_NIGHT_COLOR);
    }
}