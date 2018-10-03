package ru.innopolis.stc12.servlets.repository.dao;

import ru.innopolis.stc12.servlets.pojo.User;

public interface UserDao {
    User getUserByLogin(String login);
}
