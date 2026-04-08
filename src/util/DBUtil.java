package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String dbname = "jdbc:mysql://localhost:3306/BankManagementDBCopy";
    private static String username = "root";
    private static String password = "root";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbname, username, password);
    }

}
