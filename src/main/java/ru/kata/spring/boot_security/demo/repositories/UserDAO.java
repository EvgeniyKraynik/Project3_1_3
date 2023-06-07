package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(User updatedUser);

    void removeUser(long id);

    User findByUsername(String username);
}
