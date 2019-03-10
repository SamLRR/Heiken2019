package io.samlr.heiken.service.impl;

import io.samlr.heiken.dao.UserDao;
import io.samlr.heiken.entity.User;
import io.samlr.heiken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.create(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> getUserByDescription(String description) {
        return userDao.getUserByDescription(description);
    }
}
