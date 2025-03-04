
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getDatabaseConnection() {

        if (connection == null) {
            try {

                Class.forName(DatabaseConfig.DRIVER_NAME);

                connection = DriverManager.getConnection(DatabaseConfig.CONNECTION_STRING,
                        DatabaseConfig.DB_USER_NAME,
                        DatabaseConfig.DB_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {

                e.printStackTrace();

            }
        }

        return connection;
    }

}
