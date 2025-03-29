public interface ParkingService {
    int parkVehicle(Vehicle vehicle);
    boolean removeVehicle(int slotNumber);
    Slot getSlot(int slotNumber);
    int getAvailableSlots();
}