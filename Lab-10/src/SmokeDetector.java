public class SmokeDetector extends SensoryDevice {
    private boolean sprinklerActive;
    private double smokeLevel;
    private static final double SMOKE_THRESHOLD = 0.5; // Threshold for smoke detection

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
        // In a real implementation, this would read from a smoke sensor
        // For simulation, we'll use the sensitivity to affect the smoke detection threshold
        double adjustedThreshold = SMOKE_THRESHOLD * (11 - sensitivity) / 10.0;
        if (smokeLevel > adjustedThreshold) {
            sendNotification("Smoke detected! Level: " + String.format("%.2f", smokeLevel));
            setSprinklerActive(true);
        }
    }

    // Simulated method to update smoke level from sensor
    public void updateSmokeLevel(double level) {
        this.smokeLevel = level;
        if (isOn()) {
            processData();
        }
    }

    @Override
    protected void sendNotification(String message) {
        if (notificationEnabled) {
            // In a real implementation, this would send the notification to the user
            System.out.println("SmokeDetector Notification: " + message);
        }
    }
}