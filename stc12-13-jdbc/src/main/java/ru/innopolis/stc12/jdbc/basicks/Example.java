package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example {
    private static Logger logger = Logger.getLogger(Example.class);
    static final String SQL = "SELECT * FROM public.students";
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    public static void main(String[] args) {
        Connection connection = connectionManager.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL);) {
            logResultSet(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    static void logResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                logger.info(resultSet.getString("name") + "; ");
                logger.info(resultSet.getString("family_name") + "; ");
                logger.info(resultSet.getInt("age") + "; ");
                logger.info(resultSet.getString("city") + "; ");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
