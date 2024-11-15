package Test;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import src.UserFileManager;
import src.RegularUser;
import src.User;

public class UserManagementSystemTest {

    private static final String TEST_USER_FILE = "TestUser.csv";
    private static final String TEST_ADMIN_FILE = "TestAdmin.csv";

    @BeforeEach
    void setUp() throws IOException {
        // Create test files before each test
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_USER_FILE))) {
            bw.write("UserID,Username,Email,Password,UserType");
            bw.newLine();
            bw.write("001,johndoe,john@example.com,pass123,REGULAR");
            bw.newLine();
            bw.write("002,janedoe,jane@example.com,pass456,POWER");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_ADMIN_FILE))) {
            bw.write("UserID,Username,Email,Password");
            bw.newLine();
            bw.write("003,admin,admin@example.com,adminpass");
        }
    }

    @AfterEach
    void tearDown() {
        // Delete test files after each test
        new File(TEST_USER_FILE).delete();
        new File(TEST_ADMIN_FILE).delete();
    }

    @Test
    void testAuthenticateRegularUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        RegularUser regularUser = new RegularUser("001", "johndoe", "john@example.com", "pass123");
        assertDoesNotThrow(() -> regularUser.authenticate("pass123"));
    }

    @Test
    void testAuthenticateAdminUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        AdminUser adminUser = new AdminUser("003", "admin", "admin@example.com", "adminpass");
        assertDoesNotThrow(() -> adminUser.authenticate("adminpass"));
    }

    @Test
    void testModifyUserDetails() throws IOException {
        AdminUser admin = new AdminUser("003", "admin", "admin@example.com", "adminpass");
        admin.modifyUserDetails("001", "newemail@example.com", "newpass");

        BufferedReader br = new BufferedReader(new FileReader(TEST_USER_FILE));
        String line;
        boolean userUpdated = false;
        while ((line = br.readLine()) != null) {
            if (line.contains("newemail@example.com")) {
                userUpdated = true;
                break;
            }
        }
        br.close();

        assertTrue(userUpdated, "User details should be updated in the file.");
    }

    @Test
    void testRenameFile() {
        AdminUser admin = new AdminUser("003", "admin", "admin@example.com", "adminpass");
        admin.renameFile(TEST_USER_FILE, "RenamedTestUser.csv");

        File renamedFile = new File("RenamedTestUser.csv");
        assertTrue(renamedFile.exists(), "File should be renamed.");
        renamedFile.delete(); // Clean up after test
    }

    @Test
    void testAddUser() throws IOException {
        PowerUser powerUser = new PowerUser("002", "janedoe", "jane@example.com", "pass456");
        powerUser.addUser("004", "newuser", "newuser@example.com", "newpass", "REGULAR");

        BufferedReader br = new BufferedReader(new FileReader(TEST_USER_FILE));
        String line;
        boolean userAdded = false;
        while ((line = br.readLine()) != null) {
            if (line.contains("newuser")) {
                userAdded = true;
                break;
            }
        }
        br.close();

        assertTrue(userAdded, "New user should be added to the file.");
    }

    @Test
    void testViewUserDetails() throws IOException {
        RegularUser regularUser = new RegularUser("001", "johndoe", "john@example.com", "pass123");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outputStream));
        regularUser.viewUserDetails();
        System.setOut(originalOut);

        String output = outputStream.toString();
        assertTrue(output.contains("johndoe"), "Output should contain user details.");
    }

    @Test
    void testAuthenticateFromUserManagementSystem() {
        UserManagementSystem ums = UserManagementSystem.getInstance();

        User regularUser = assertDoesNotThrow(() -> ums.authenticate("johndoe", "pass123"));
        assertNotNull(regularUser);
        assertEquals("johndoe", regularUser.getUsername());

        User adminUser = assertDoesNotThrow(() -> ums.authenticate("admin", "adminpass"));
        assertNotNull(adminUser);
        assertEquals("admin", adminUser.getUsername());
    }
}
