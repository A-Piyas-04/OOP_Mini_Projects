# Refactoring

The following refactoring improvements were made to enhance code quality and maintainability:

### 1. Extract Method
- **Improvement**: Extracted the flight scheduling logic from the Flight class to a new FlightScheduler class

### 2. Encapsulate Collections in Flight Class
- **Improvement**: Enhanced encapsulation of customer list access and datetime handling
- **Implementation**:
  - Replaced direct access to `listOfRegisteredCustomersInAFlight` with proper getter, adder, and remover methods
  - Modified datetime truncation to use `withSecond(0).withNano(0)` instead of `truncatedTo(ChronoUnit.MINUTES)` for clarity

### 3. Removal of Magic Literal
- **Improvement**: Replaced hardcoded values with named constants to improve code readability and maintainability

### 4. Decompose Conditional in User Class
- **Improvement**: Extracted login and menu handling logic into separate methods
- **Implementation**: The main method in the User class was split into smaller, focused methods:
  - `handleAdminLogin`
  - `handlePassengerLogin`
  - `handleAdminMenu`
  - `handlePassengerMenu`
  - `handleAdminMenuChoice`
  - `handlePassengerMenuChoice`

### 5. Move flight-search Method
- **Improvement**: Relocated the `findFlightByNumber` method from the `Customer` class to the `Flight` class
- **Benefit**: Improved code organization and maintainability

### 6. Introduce Parameter Object
- **Improvement**: Created a dedicated class for flight details
- **Implementation**:
  - Created new `FlightDetails` class
  - Modified `Flight` class constructor to use `FlightDetails` object

### 7. Rename Methods in RolesAndPermissions
- **Improvement**: Enhanced method naming clarity
- **Changes**:
  - Renamed `isPrivilegedUserOrNot` to `validateAdminCredentials`
  - Renamed `isPassengerRegistered` to `validatePassengerCredentials`
