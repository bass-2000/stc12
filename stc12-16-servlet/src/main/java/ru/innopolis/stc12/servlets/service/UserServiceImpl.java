package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.User;
import ru.innopolis.stc12.servlets.repository.dao.UserDao;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public int getRole(String login) {
        User user;
        if (login != null) {
            user = userDao.getUserByLogin(login);
            if (user == null) {
                return -1;
            }
            return user.getRole();
        }
        return -2;
    }

    @Override
    public boolean checkAuth(String login, String password) {
        //TODO: УДалить тестовые учетки
        User user;
        if ((login != null) && (password != null)) {
            user = userDao.getUserByLogin(login);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

}
