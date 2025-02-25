abstract class SecurityDevice extends AbstractDevice {
    protected boolean notificationEnabled;

    public SecurityDevice() {
        super();
        this.notificationEnabled = true;
    }

    public void setNotificationEnabled(boolean enabled) {
        this.notificationEnabled = enabled;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

   abstract void sendNotification(String message);
}