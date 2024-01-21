package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * La classe ConnectionPool fornisce un pool di connessioni al database per garantire un uso efficiente delle risorse.
 * Le connessioni al database vengono gestite in un pool per evitare la creazione e la chiusura frequente di connessioni.
 * La classe utilizza il driver JDBC di MySQL per interagire con il database "GoldenOnlineStore".
 */
public class ConnectionPool {

    private static List<Connection> freeDbConnections;
    private static final String username = "root";
    private static final String password = "Totobitto.98";
    private static Connection newConnection;

    /**
     * Metodo che ottiene una connessione dal pool.
     *
     * @return Una connessione al database.
     * @throws SQLException Se si verifica un'eccezione durante l'accesso al database.
     */
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