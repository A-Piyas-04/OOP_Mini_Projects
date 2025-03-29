public class Slot {
    private int slotNumber;
    private boolean isAvailable;
    private String registrationNumber;
    private String color;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isAvailable = true;
    }

    public void parkCar(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.isAvailable = false;
    }

    public void leaveSlot() {
        this.registrationNumber = null;
        this.color = null;
        this.isAvailable = true;
    }

    // Getters
    public int getSlotNumber() { return slotNumber; }
    public boolean isAvailable() { return isAvailable; }
    public String getRegistrationNumber() { return registrationNumber; }
    public String getColor() { return color; }
}