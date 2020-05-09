import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASS = "1111";
    private Connection connection;

    public DBWorker() {
        try {
//            Driver driver = new Driver();
//            DriverManager.registerDriver(driver);
               connection = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException sqlException) {
            System.err.println("Не удалось соединиться с БД!");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
