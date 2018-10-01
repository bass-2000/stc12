package ru.innopolis.stc12.jdbc.basicks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example3 {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", Example.password);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students set age =35  WHERE public.students.id = ? ");) {

            for (String arg : args) {
                preparedStatement.setInt(1, Integer.parseInt(arg));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


