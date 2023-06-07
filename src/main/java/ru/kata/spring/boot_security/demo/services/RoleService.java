package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    void saveRole(Role role);

    Role getRole(long id);

    void updateRole(Role updateRole);

    void deleteRole(long id);

    Set<Role> getAllRolesByUser(User user);
}
