package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
//        return entityManager.find(User.class, id);
        return entityManager.createQuery("from User u left join fetch u.roles where u.id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void removeUser(long id) {
        entityManager.createQuery("delete User where id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("from User u left join fetch u.roles where u.username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
