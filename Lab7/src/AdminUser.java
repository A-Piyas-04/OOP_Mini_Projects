public class AdminUser extends User implements Administration {
    public AdminUser(String userId, String username, String email, String password) {
        super(userId, username, email, password);
    }

    @Override
    public void authenticate(String password) {
        if (this.password.equals(password)) {
            System.out.println("Admin user authenticated.");
        } else {
            throw new SecurityException("Invalid password for admin.");
        }
    }

    @Override
    public void modifyUserDetails(String userId, String newEmail, String newPassword) {
        System.out.println("Modifying user details for user: " + userId);
        // Logic to modify user details in User.csv
    }

    @Override
    public void renameFile(String oldFileName, String newFileName) {
        System.out.println("Renaming file from " + oldFileName + " to " + newFileName);
        // Logic to rename the file
    }
}
