package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Communicator {
    private Connection connection;
    private static Communicator instance;

    public static Communicator getInstance() {
        if (instance != null) return instance;
        else return instance = new Communicator();
    }

    public Communicator() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Fulfillment?user=root&password=");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
