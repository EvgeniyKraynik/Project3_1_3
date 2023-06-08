package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleDAO;
import ru.kata.spring.boot_security.demo.repositories.UserDAO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserDAO userDAO, RoleDAO roleDAO) {
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(user.getRoles());
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser) {
        updatedUser.setPassword((passwordEncoder.encode((updatedUser.getPassword()))));
        updatedUser.setRoles(roleDAO.getAllRolesByUserId(updatedUser.getId()));
        userDAO.updateUser(updatedUser);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
