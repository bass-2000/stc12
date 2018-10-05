package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.innopolis.stc12.jdbc.basicks.Example.logResultSet;

public class Example2 {
    static ResultSet resultSet;
    private static Logger logger = Logger.getLogger(Example2.class);
    static final String SQL = "SELECT * FROM public.students  WHERE public.students.city = ? AND age > ?";
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    public static void main(String[] args) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ) {
            preparedStatement.setString(1, "Rostov");
            preparedStatement.setInt(2, 19);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                logResultSet(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}

