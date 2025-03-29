import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {
    private final List<Slot> slots;
    
    public ParkingLot(int capacity) {
        this.slots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            slots.add(new Slot(i));
        }
    }
    
    public int parkCar(String registrationNumber, String color) {
        for (Slot slot : slots) {
            if (slot.isAvailable()) {
                slot.parkCar(registrationNumber, color);
                return slot.getSlotNumber();
            }
        }
        return -1;
    }
    
    public boolean leaveSlot(int slotNumber) {
        for (Slot slot : slots) {
            if (slot.getSlotNumber() == slotNumber) {
                slot.leaveSlot();
                return true;
            }
        }
        return false;
    }
    
    public String getStatus() {
        StringBuilder status = new StringBuilder("Slot No.\tRegistration No\tColor\n");
        for (Slot slot : slots) {
            if (!slot.isAvailable()) {
                status.append(slot.getSlotNumber()).append("\t")
                      .append(slot.getRegistrationNumber()).append("\t")
                      .append(slot.getColor()).append("\n");
            }
        }
        return status.toString();
    }
    
    public List<String> getRegistrationNumbersByColor(String color) {
        return slots.stream()
                .filter(slot -> !slot.isAvailable() && slot.getColor().equalsIgnoreCase(color))
                .map(Slot::getRegistrationNumber)
                .collect(Collectors.toList());
    }
    
    public int getSlotNumberByRegistration(String registrationNumber) {
        return slots.stream()
                .filter(slot -> !slot.isAvailable() && slot.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                .findFirst()
                .map(Slot::getSlotNumber)
                .orElse(-1);
    }
    
    public List<Integer> getSlotNumbersByColor(String color) {
        return slots.stream()
                .filter(slot -> !slot.isAvailable() && slot.getColor().equalsIgnoreCase(color))
                .map(Slot::getSlotNumber)
                .collect(Collectors.toList());
    }
}