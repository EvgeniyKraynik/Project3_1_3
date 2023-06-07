package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleDAO;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    public Role getRole(long id) {
        return roleDAO.getRole(id);
    }

    @Override
    public void updateRole(Role updateRole) {
        roleDAO.updateRole(updateRole);
    }

    @Override
    public void deleteRole(long id) {
        roleDAO.deleteRole(id);
    }

    @Override
    public Set<Role> getAllRolesByUser(User user) {
        return roleDAO.getAllRolesByUser(user);
    }
}
