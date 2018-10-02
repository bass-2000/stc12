package ru.innopolis.stc12.servlets.repository.connectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerJdbcImpl implements ConnectionManager {
    private static ConnectionManager connectionManager;
    Properties property = new Properties();

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
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("config.properties");
            property.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = property.getProperty("driver");
        String password = property.getProperty("password");
        String user = property.getProperty("username");
        String url = property.getProperty("url");
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}