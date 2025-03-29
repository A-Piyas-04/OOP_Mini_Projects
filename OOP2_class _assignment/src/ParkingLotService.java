import java.util.ArrayList;
import java.util.List;

public class ParkingLotService implements ParkingService {
    private final List<Slot> slots;
    
    public ParkingLotService(int capacity) {
        this.slots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            slots.add(new Slot(i));
        }
    }
    
    @Override
    public int parkVehicle(Vehicle vehicle) {
        for (Slot slot : slots) {
            if (slot.isAvailable()) {
                slot.parkCar(vehicle.getRegistrationNumber(), vehicle.getColor());
                return slot.getSlotNumber();
            }
        }
        return -1;
    }
    
    @Override
    public boolean removeVehicle(int slotNumber) {
        for (Slot slot : slots) {
            if (slot.getSlotNumber() == slotNumber) {
                slot.leaveSlot();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Slot getSlot(int slotNumber) {
        return slots.stream()
                .filter(slot -> slot.getSlotNumber() == slotNumber)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public int getAvailableSlots() {
        return (int) slots.stream()
                .filter(Slot::isAvailable)
                .count();
    }
    
    protected List<Slot> getSlots() {
        return slots;
    }
}