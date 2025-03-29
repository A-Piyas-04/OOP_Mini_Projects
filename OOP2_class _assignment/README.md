# Parking Lot System

## 1. System Requirements

### 1.1 Parking Lot Initialization
The system should create a parking lot with n slots (n is given as input).
Slots are numbered from 1 to n, with 1 being the closest to the entry.

### 1.2 Ticket Issuance
When a car enters:
- Assign the nearest available slot.
- Record the registration number and color of the car.
- Generate a ticket with:
  - Allocated slot number
  - Registration number
  - Car color

### 1.3 Ticket Return
When a car exits:
- The assigned slot is marked as available.
- The car's details are removed from the system.

### 1.4 Government Regulation Queries
The system should answer the following queries:
- Find all registration numbers for cars of a particular color.
- Find the slot number where a car with a given registration number is parked.
- Find all slot numbers for cars of a particular color.

### 1.5 Input Modes
The system should support an interactive command prompt.

## 2. Commands to Support

The system must support the following commands:

### 2.1 Create a Parking Lot
Command: `create_parking_lot <n>`
Action: Initializes a parking lot with n slots.
Output: "Created a parking lot with <n> slots"

### 2.2 Park a Car
Command: `park <registration_number> <color>`
Action: Allocates the nearest available slot to the car.
Output:
- "Allocated slot number: <slot_number>"
- If full: "Sorry, parking lot is full"

### 2.3 Leave a Slot
Command: `leave <slot_number>`
Action: Marks the slot as available and removes car details.
Output: "Slot number <slot_number> is free"

### 2.4 Status of Parking Lot
Command: `status`
Action: Displays the current occupancy of the parking lot.
Output: A table showing:
- Slot numbers
- Registration numbers
- Car colors

### 2.5 Query Registration Numbers by Color
Command: `registration_numbers_for_cars_with_colour <color>`
Action: Returns all registration numbers for cars of the specified color.
Output: Comma-separated list of registration numbers.
Example: "KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333"
If none found: "Not found"

### 2.6 Query Slot Number by Registration Number
Command: `slot_number_for_registration_number <registration_number>`
Action: Returns the slot number where the specified car is parked.
Output: <slot_number>
If not found: "Not found"

### 2.7 Query Slot Numbers by Color
Command: `slot_numbers_for_cars_with_colour <color>`
Action: Returns all slot numbers where cars of the specified color are parked.
Output: Comma-separated slot numbers.
Example: "1, 2, 4"
If none found: "Not found"

### 2.8 Exit the System
Command: `exit`
Action: Exits the interactive command prompt.