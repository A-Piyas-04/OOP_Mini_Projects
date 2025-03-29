import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int totalSlots;
    private List<Slot> slots;

    public ParkingLot(int n) {
        this.totalSlots = n;
        this.slots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            slots.add(new Slot(i));
        }
    }

    public int parkCar(String registrationNumber, String color) {
        // Implementation for parking a car
    }

    public boolean leaveSlot(int slotNumber) {
        // Implementation for leaving a slot
    }

    public String getStatus() {
        // Implementation for getting status
    }

    public List<String> getRegistrationNumbersByColor(String color) {
        // Implementation for color query
    }

    public int getSlotNumberByRegistration(String registrationNumber) {
        // Implementation for registration query
    }

    public List<Integer> getSlotNumbersByColor(String color) {
        // Implementation for slot color query
    }
}