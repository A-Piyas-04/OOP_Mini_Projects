public class SecurityCamera extends SecurityDevice {
    private boolean autoSave;
    private boolean liveFeedActive;

    public SecurityCamera() {
        super();
        this.autoSave = true;
        this.liveFeedActive = false;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public boolean isAutoSave() {
        return autoSave;
    }

    public void startLiveFeed() {
        if (!isOn()) {
            return;
        }
        this.liveFeedActive = true;
        sendNotification("Live feed started");
    }

    public void stopLiveFeed() {
        if (!isOn()) {
            return;
        }
        this.liveFeedActive = false;
        if (autoSave) {
            sendNotification("Live feed stopped and saved");
        } else {
            sendNotification("Live feed stopped");
        }
    }

    public boolean isLiveFeedActive() {
        return liveFeedActive;
    }

    @Override
    public void turnOff() {
        if (liveFeedActive) {
            stopLiveFeed();
        }
        super.turnOff();
    }

    @Override
    protected void sendNotification(String message) {
        if (notificationEnabled) {
            System.out.println("SecurityCamera Notification: " + message);
        }
    }
}