import java.util.ArrayList;
import java.util.List;

public class UserManagementSystem {
    private static UserManagementSystem instance; // Singleton instance
    private List<User> users; // Shared resource: list of users

    private UserManagementSystem() {
        users = new ArrayList<>();
        // Load users from User.csv
        loadUsersFromFile("User.csv");
    }

    public static UserManagementSystem getInstance() {
        if (instance == null) {
            synchronized (UserManagementSystem.class) { // Thread-safe initialization
                if (instance == null) {
                    instance = new UserManagementSystem();
                }
            }
        }
        return instance;
    }

    public void loadUsersFromFile(String filePath) {
        try {List<String> lines = FileHandler.readFile(filePath);
            for (String line : lines) {
                String[] fields = line.split(",");
                String userId = fields[0];
                String username = fields[1];
                String email = fields[2];
                String password = fields[3];
                UserType userType = UserType.valueOf(fields[4].toUpperCase()); // Ensure case-insensitivity

                switch (userType) {
                    case ADMIN:
                        users.add(new AdminUser(userId, username, email, password));
                        break;
                    case POWER:
                        users.add(new PowerUser(userId, username, email, password));
                        break;
                    case REGULAR:
                        users.add(new RegularUser(userId, username, email, password));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown user type: " + userType);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.authenticate(password);
                return user;
            }
        }
        throw new SecurityException("User not found or invalid credentials.");
    }

    public List<User> getUsers() {
        return users;
    }
}
