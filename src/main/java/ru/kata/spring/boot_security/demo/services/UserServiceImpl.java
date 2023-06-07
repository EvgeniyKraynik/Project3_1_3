package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserDAO;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserDAO userDAO;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserDAO userDAO) {
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(user.getRoles());
        userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        updatedUser.setPassword((passwordEncoder.encode((updatedUser.getPassword()))));
        updatedUser.setRoles(updatedUser.getRoles());
        userDAO.updateUser(updatedUser);
    }

    @Override
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
