import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;


public class Main2 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASS = "1111";
    private static final String INSERT_NEW="INSERT INTO user(username,password,icon) VALUES(?,?,?)";
    public static void main(String[] args) {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException sqlException) {
            System.err.println("Не удалось загрузить драйвер!");
        }
        try(
                Connection connection = DriverManager.getConnection(URL,USERNAME,PASS);
                PreparedStatement preparedStatement =connection.prepareStatement(INSERT_NEW);
        )
        {
            preparedStatement.setString(1,"Serg");
            preparedStatement.setString(2,"PassSerg");
            preparedStatement.setBlob(3,new FileInputStream("icon.jpg"));
            preparedStatement.execute();
        }catch (SQLException sqlException){
            System.err.println("Соединние с БД не установлено");
            sqlException.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("Не удалось записать файл в БД");
        }

    }
}
