package ru.innopolis.stc12.jdbc.basicks;

import java.sql.*;

public class Example2 {
    static ResultSet resultSet;
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", "master");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.students  WHERE public.students.city = ? AND age > ?");
        ) {
            preparedStatement.setString(1, "Rostov");
            preparedStatement.setInt(2, 19);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + "; ");
                System.out.print(resultSet.getString("family_name") + "; ");
                System.out.print(resultSet.getInt("age") + "; ");
                System.out.print(resultSet.getString("city") + "; ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

