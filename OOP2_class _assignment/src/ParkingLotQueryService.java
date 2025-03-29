import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotQueryService implements ParkingQueryService {
    private final ParkingLotService parkingService;
    
    public ParkingLotQueryService(ParkingLotService parkingService) {
        this.parkingService = parkingService;
    }
    
    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder("Slot No.\tRegistration No\tColor\n");
        for (Slot slot : parkingService.getSlots()) {
            if (!slot.isAvailable()) {
                status.append(slot.getSlotNumber()).append("\t")
                      .append(slot.getRegistrationNumber()).append("\t")
                      .append(slot.getColor()).append("\n");
            }
        }
        return status.toString();
    }
    
    @Override
    public List<String> getRegistrationNumbersByColor(String color) {
        return parkingService.getSlots().stream()
                .filter(slot -> !slot.isAvailable() && slot.getColor().equalsIgnoreCase(color))
                .map(Slot::getRegistrationNumber)
                .collect(Collectors.toList());
    }
    
    @Override
    public int getSlotNumberByRegistration(String registrationNumber) {
        return parkingService.getSlots().stream()
                .filter(slot -> !slot.isAvailable() && 
                       slot.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                .findFirst()
                .map(Slot::getSlotNumber)
                .orElse(-1);
    }
    
    @Override
    public List<Integer> getSlotNumbersByColor(String color) {
        return parkingService.getSlots().stream()
                .filter(slot -> !slot.isAvailable() && slot.getColor().equalsIgnoreCase(color))
                .map(Slot::getSlotNumber)
                .collect(Collectors.toList());
    }
}