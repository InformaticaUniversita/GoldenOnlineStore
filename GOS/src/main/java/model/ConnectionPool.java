package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class ConnectionPool {

    private static List<Connection> freeDbConnections;
    private static final String username = "root";
    private static final String password = "Totobitto.98";
    private static Connection newConnection;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver not found:" + e.getMessage());
        }
        if (newConnection == null) {
            newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GoldenOnlineStore", username, password);
            newConnection.setAutoCommit(false);
        }
        if (newConnection.isClosed()) {
            newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GoldenOnlineStore", username, password);
        }

        return newConnection;
    }
}