import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASS = "1111";
    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASS);

            if (!connection.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
            connection.close();

            if (connection.isClosed()){
                System.out.println("Соединение с БД закрыто");
            }
        } catch (SQLException sqlException) {
            System.err.println("Не удалось загрузить драйвер!");
        }
    }
}
