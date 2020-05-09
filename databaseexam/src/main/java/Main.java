import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASS = "1111";
    public static void main(String[] args) {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException sqlException) {
            System.err.println("Не удалось загрузить драйвер!");
        }
        try(
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASS);
            Statement statement =connection.createStatement();
        )
        {
//            statement.execute("INSERT INTO animal (anim_name, anim_desc) VALUES ('name','desc')");
//            int res=statement.executeUpdate("UPDATE animal SET anim_name='New Name' WHERE id=1");
//            System.out.println("Изменено записей: " + res);
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
            //пакетное выполнение комманд
            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch1','desc1')");
            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch2','desc2')");
            statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch3','desc3')");
            statement.executeBatch();
            //очистка оереди запросов
            statement.clearBatch();

        }catch (SQLException sqlException){
            System.err.println("Соединние с БД не установлено");
            sqlException.printStackTrace();
        }

    }
}
