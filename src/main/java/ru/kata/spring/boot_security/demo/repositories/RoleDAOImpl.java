package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void updateRole(Role updateRole) {
        entityManager.merge(updateRole);
    }

    @Override
    public void deleteRole(long id) {
        entityManager.remove(id);
    }

    @Override
    public Set<Role> getAllRolesByUser(User user) {
        return entityManager.createQuery("from Role r join r.users u where u = :user", Role.class)
                .setParameter("user", user).getResultStream().collect(Collectors.toSet());
    }
}
