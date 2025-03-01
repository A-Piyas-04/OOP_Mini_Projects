public class SecurityAlarm extends SecurityDevice {
    private String password;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;

    public SecurityAlarm() {
        super();
        this.password = "99999";
        this.failedAttempts = 0;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPassword(String inputPassword) {
        boolean isCorrect = this.password.equals(inputPassword);
        if (isCorrect) {
            failedAttempts = 0;
            sendNotification("Password verified successfully");
        } else {
            failedAttempts++;
            sendNotification("Password verification failed. Attempt " + failedAttempts + " of " + MAX_FAILED_ATTEMPTS);
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                sendNotification("Maximum failed attempts reached. System locked.");
                turnOff();
            }
        }
        return isCorrect;
    }

    @Override
    protected void sendNotification(String message) {
        if (notificationEnabled) {
            System.out.println("SecurityAlarm Notification: " + message);
        }
    }
}