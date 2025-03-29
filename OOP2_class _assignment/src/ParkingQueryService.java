import java.util.List;

public interface ParkingQueryService {
    String getStatus();
    List<String> getRegistrationNumbersByColor(String color);
    int getSlotNumberByRegistration(String registrationNumber);
    List<Integer> getSlotNumbersByColor(String color);
}