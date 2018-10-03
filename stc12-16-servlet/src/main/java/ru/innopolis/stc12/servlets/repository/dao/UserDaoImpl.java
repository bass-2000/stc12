package ru.innopolis.stc12.servlets.repository.dao;

import ru.innopolis.stc12.servlets.pojo.User;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * from users WHERE username = ?");) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
