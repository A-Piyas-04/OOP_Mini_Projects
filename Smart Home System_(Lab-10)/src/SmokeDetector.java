public class SmokeDetector extends SensoryDevice {
    boolean sprinklerActive;
    double smokeLevel;
    private static final double SMOKE_THRESHOLD = 0.5;

    public SmokeDetector() {
        super();
        this.sprinklerActive = false;
        this.smokeLevel = 0.0;
    }

    public void setSprinklerActive(boolean active) {
        this.sprinklerActive = active;
        if (active) {
            sendNotification("Sprinkler system activated");
        } else {
            sendNotification("Sprinkler system deactivated");
        }
    }

    public boolean isSprinklerActive() {
        return sprinklerActive;
    }

    @Override
    protected void processData() {
        double adjustedThreshold = SMOKE_THRESHOLD * (11 - sensitivity) / 10.0;
        if (smokeLevel > adjustedThreshold) {
            sendNotification("Smoke detected! Level: " + String.format("%.2f", smokeLevel));
            setSprinklerActive(true);
        }
    }


    @Override
    protected void sendNotification(String message) {
        if (notificationEnabled) {
            System.out.println("SmokeDetector Notification: " + message);
        }
    }
}