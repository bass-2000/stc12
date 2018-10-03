package ru.innopolis.stc12.jdbc.realExample.ConnectionManager;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManager {
    private static Logger logger = Logger.getLogger(ConnectionManagerJdbcImpl.class);
    private static ConnectionManager connectionManager;

    private ConnectionManagerJdbcImpl() {

    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJdbcImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", "master");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }
}
