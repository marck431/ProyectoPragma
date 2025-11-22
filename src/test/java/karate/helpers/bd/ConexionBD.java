package karate.helpers.bd;

import java.sql.*;


public class ConexionBD {

    static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        String DB_URL = "jdbc:mysql://localhost/persona_db?serverTimezone=UTC";
        String USER = "root";
        String PASSWORD = "123456";
        if (connection == null) {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        return connection;
    }

}
