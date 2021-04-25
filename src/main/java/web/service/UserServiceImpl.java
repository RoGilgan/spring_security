package web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleService roleService) {
        this.userDao = userDao;
        this.roleService = roleService;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        Set<Role> setOfRoles = new HashSet<>();
        setOfRoles.add(roleService.getRoleById(2));
        user.setRoles(setOfRoles);
        return userDao.saveUser(user);
    }

    @Transactional
    @Override
    public User updateUser(User updateUser, String[] arr) {
        Set<Role> setOfRoles = new HashSet<>();

        for (String s : arr) {
            setOfRoles.add(roleService.getRoleById(Integer.parseInt(s)));
        }
        updateUser.setRoles(setOfRoles);
        return userDao.updateUser(updateUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
}
