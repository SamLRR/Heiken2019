package io.samlr.heiken.dao;

import io.samlr.heiken.entity.User;

import java.util.List;

public interface UserDao extends BasicDao<User> {

    User getUserByLogin(String login);

    User getUserById(Long id);

    List<User> getAllUsers();

    List<User> getUserByDescription(String description);
}
