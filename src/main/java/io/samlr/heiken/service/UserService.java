package io.samlr.heiken.service;

import io.samlr.heiken.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User getUserByLogin(String name);

    User updateUser(User user);

    List<User> getUserByDescription(String ip);
}
