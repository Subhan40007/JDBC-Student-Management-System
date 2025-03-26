package aze.company.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class Found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Didn't Find!");
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project-jdbc", "root", "2222");
            System.out.println("DataBase Connection is Succesful!");
        } catch (SQLException e) {
            System.out.println("DataBase Connection isn't Succesful!");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("DataBase close is succesful!");
        } catch (SQLException e) {
            System.out.println("DataBase close is fail!");
        }
    }

}
