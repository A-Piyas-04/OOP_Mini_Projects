public class PowerUser extends User implements WriteOnly {
    public PowerUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public void authenticate(String password) {
        if (this.password.equals(password)) {
            System.out.println("Power user authenticated.");
        } else {
            throw new SecurityException("Invalid password for power user.");
        }
    }

    @Override
    public void addUser(String userId, String username, String email, String password, String userType) {
        System.out.println("Adding user: " + username);
        // Logic to add a user to User.csv
    }
}
