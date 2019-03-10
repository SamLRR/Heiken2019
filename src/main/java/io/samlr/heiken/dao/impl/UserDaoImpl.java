package io.samlr.heiken.dao.impl;

import io.samlr.heiken.dao.UserDao;
import io.samlr.heiken.entity.User;

import java.util.List;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getUserByDescription(String description) {
        return null;
    }
}
