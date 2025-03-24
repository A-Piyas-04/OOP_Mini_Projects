### Refactoring

The following refactoring improvements were made :

1.**Extract Method** :
- Extracted the flight scheduling logic from the Flight class to a new FlightScheduler class

2. **Encapsulate Collections** in Flight Class :
- Encapsulate customer list access and improve datetime handling'

- Replace direct access to listOfRegisteredCustomersInAFlight with proper getter, adder, and remover methods to ensure encapsulation. Modify datetime truncation to use withSecond(0).withNano(0) instead of truncatedTo(ChronoUnit.MINUTES) for clarity.

3. **Removal of Magic Literal** :
- Replaced hardcoded values with named constants to improve code readability and maintainability.

4. **Decompose Conditional** in User Class :
- Extract login and menu handling logic into separate methods.

- The main method in the User class was becoming too lengthy and complex. To improve readability and maintainability, the login and menu handling logic for both admin and passenger roles has been extracted into separate methods: `handleAdminLogin`, `handlePassengerLogin`, `handleAdminMenu`, `handlePassengerMenu`, `handleAdminMenuChoice`, and `handlePassengerMenuChoice`.

5. **Move flight-search Method** from Customer to Flight :
- Relocate the `findFlightByNumber` method from the `Customer` class to the `Flight` class to improve code organization and maintainability.

6. **Introduce Parameter Object** :
- Created FlightDetails class
- Modified constructor of Flight class so that it uses FlightDetails object.

7. **Rename Methods** in RolesAndPermissions :
- Rename 'isPrivilegedUserOrNot' to 'validateAdminCredentials' and 'isPassengerRegistered' to 'validatePassengerCredentials'.
