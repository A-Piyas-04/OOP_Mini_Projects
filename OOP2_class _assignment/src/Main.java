import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingService parkingService = null;
        ParkingQueryService parkingQueryService = null;
        
        while (true) {
            System.out.print("-> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            
            if (parts[0].equals("exit")) {
                break;
            } else if (parts[0].equals("create_parking_lot") && parts.length == 2) {
                int n = Integer.parseInt(parts[1]);
                parkingService = new ParkingLotService(n);
                parkingQueryService = new ParkingLotQueryService((ParkingLotService) parkingService);
                System.out.println("Created a parking lot with " + n + " slots");
            } else if (parts[0].equals("park") && parts.length == 3) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                String regNumber = parts[1];
                String color = parts[2];
                Vehicle vehicle = new Vehicle(regNumber, color);
                int slot = parkingService.parkVehicle(vehicle);
                if (slot == -1) {
                    System.out.println("Sorry, parking lot is full");
                } else {
                    System.out.println("Allocated slot number: " + slot);
                }
            } else if (parts[0].equals("leave") && parts.length == 2) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                int slotNumber = Integer.parseInt(parts[1]);
                boolean success = parkingService.removeVehicle(slotNumber);
                if (success) {
                    System.out.println("Slot number " + slotNumber + " is free");
                }
            } else if (parts[0].equals("status") && parts.length == 1) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                System.out.println(parkingQueryService.getStatus());
            } else if (parts[0].equals("registration_numbers_for_cars_with_colour") && parts.length == 2) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                List<String> regNumbers = parkingQueryService.getRegistrationNumbersByColor(parts[1]);
                if (regNumbers.isEmpty()) {
                    System.out.println("Not found");
                } else {
                    System.out.println(String.join(", ", regNumbers));
                }
            } else if (parts[0].equals("slot_number_for_registration_number") && parts.length == 2) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                int slot = parkingQueryService.getSlotNumberByRegistration(parts[1]);
                if (slot == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println(slot);
                }
            } else if (parts[0].equals("slot_numbers_for_cars_with_colour") && parts.length == 2) {
                if (parkingService == null) {
                    System.out.println("Please create a parking lot first");
                    continue;
                }
                List<Integer> slots = parkingQueryService.getSlotNumbersByColor(parts[1]);
                if (slots.isEmpty()) {
                    System.out.println("Not found");
                } else {
                    System.out.println(slots.stream().map(String::valueOf).collect(Collectors.joining(", ")));
                }
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}