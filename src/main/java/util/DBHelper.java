package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "e8889@pg";

    private Connection connection;

    public Connection connection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
