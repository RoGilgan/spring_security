package web.dao;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;

    public UserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> showAllUsers() {
        return entityManager.createQuery("SELECT DISTINCT u FROM  User u LEFT JOIN FETCH u.roles r", User.class)
                .getResultList();
    }

    @Override
    public User showUser(Long id) {
        return entityManager.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles r " +
                "WHERE u.id =: id", User.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updateUser(User updateUser) {
        entityManager.merge(updateUser);
        return updateUser;
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id=: id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserByLogin(String login) {
        return entityManager.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.roles r " +
                "WHERE u.login=:login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
