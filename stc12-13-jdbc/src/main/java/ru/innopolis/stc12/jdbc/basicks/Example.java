package ru.innopolis.stc12.jdbc.basicks;

import java.sql.*;

public class Example {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MobilePhones", "postgres", "master");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.students ");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + "; ");
                System.out.print(resultSet.getString("family_name") + "; ");
                System.out.print(resultSet.getInt("age") + "; ");
                System.out.print(resultSet.getString("city") + "; ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
