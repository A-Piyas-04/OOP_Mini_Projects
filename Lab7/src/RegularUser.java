public class RegularUser extends User implements ReadOnly {
    public RegularUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public void authenticate(String password) {
        if (this.password.equals(password)) {
            System.out.println("Regular user authenticated.");
        } else {
            throw new SecurityException("Invalid password for regular user.");
        }
    }

    @Override
    public void viewUserDetails() {
        System.out.println("Viewing user details.");
        // Logic to read User.csv
    }
}
