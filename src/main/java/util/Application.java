package util;

import java.sql.Connection;

public class Application {
    private static Connection connection = new DBHelper().connection();

    public static Connection getConnection() {
        return connection;
    }
}
