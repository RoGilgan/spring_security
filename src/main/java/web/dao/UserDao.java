package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> showAllUsers();

    User showUser(Long id);

    User saveUser(User user);

    User updateUser(User updateUser);

    void deleteUser(Long id);

    User getUserByLogin(String login);
}
