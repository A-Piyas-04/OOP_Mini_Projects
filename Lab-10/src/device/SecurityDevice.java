package device;

public abstract class SecurityDevice implements Device {
    protected boolean isOn;
    protected String location;
    protected boolean notificationEnabled;

    public SecurityDevice() {
        this.isOn = false;
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

    public void setNotificationEnabled(boolean enabled) {
        this.notificationEnabled = enabled;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    protected abstract void sendNotification(String message);
}