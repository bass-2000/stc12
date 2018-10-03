package ru.innopolis.stc12.jdbc.basicks;

import org.apache.log4j.Logger;

import java.sql.*;

public class Example {
    private static Logger logger = Logger.getLogger(Example.class);
    final static String password = "master";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM public.students ");) {

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
