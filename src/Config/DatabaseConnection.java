package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/facilities_management";
    private static final String USER = "root";
    private static final String PASSWORD = "26052005Nan@";

    public static Connection getConnection() {
        try {
        	Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối MySQL thành công!");
            return connection;
        } catch (SQLException e) {
        	System.out.println("Kết nối MySQL không thành công!");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
