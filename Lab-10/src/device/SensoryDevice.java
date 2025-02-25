package device;

public abstract class SensoryDevice implements Device {
    protected boolean isOn;
    protected String location;
    protected int sensitivity;
    protected boolean notificationEnabled;

    public SensoryDevice() {
        this.isOn = false;
        this.sensitivity = 5; // Default sensitivity in the middle of 1-10 range
        this.notificationEnabled = true;
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

    public void setSensitivity(int sensitivity) {
        if (sensitivity < 1 || sensitivity > 10) {
            throw new IllegalArgumentException("Sensitivity must be between 1 and 10");
        }
        this.sensitivity = sensitivity;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setNotificationEnabled(boolean enabled) {
        this.notificationEnabled = enabled;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    protected abstract void processData();
    protected abstract void sendNotification(String message);
}