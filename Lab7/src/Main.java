public class Main {
    public static void main(String[] args) {
        UserManagementSystem ums = UserManagementSystem.getInstance();

        // Authenticate a user
        try {
            User user = ums.authenticate("admin", "password");
            System.out.println(user.getUsername() + " authenticated successfully.");
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        // Print all users
        for (User user : ums.getUsers()) {
            System.out.println(user.getUsername() + " (" + user.getClass().getSimpleName() + ")");
        }
    }
}
