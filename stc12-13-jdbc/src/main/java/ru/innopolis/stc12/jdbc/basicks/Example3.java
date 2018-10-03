package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example3 {
    private static Logger logger = Logger.getLogger(Example3.class);
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", Example.password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students set age =35  WHERE public.students.id = ? ");) {

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


