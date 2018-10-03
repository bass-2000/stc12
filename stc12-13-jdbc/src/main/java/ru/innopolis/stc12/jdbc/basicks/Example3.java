package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManager;
import ru.innopolis.stc12.jdbc.realExample.ConnectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example3 {
    private static Logger logger = Logger.getLogger(Example3.class);
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    public static void main(String[] args) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students set age =35  WHERE public.students.id = ? ");) {

            for (String arg : args) {
                preparedStatement.setInt(1, Integer.parseInt(arg));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }
}


