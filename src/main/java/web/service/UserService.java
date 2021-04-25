package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();

    User showUser(Long id);

    User saveUser(User user);

    User updateUser(User updateUser, String[] arr);

    void deleteUser(Long id);

    User getUserByLogin(String login);
}
