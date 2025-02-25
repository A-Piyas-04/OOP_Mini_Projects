abstract class SensoryDevice extends AbstractDevice {
    protected int sensitivity;
    protected boolean notificationEnabled;

    public SensoryDevice() {
        super();
        this.sensitivity = 5; // Default sensitivity in the middle of 1-10 range
        this.notificationEnabled = true;
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