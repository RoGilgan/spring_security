package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public Role saveRole(Role role) {
        return roleDao.saveRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }

    @Override
    public List<Role> getRoles(String[] arr) {
        return roleDao.getRoles(arr);
    }
}
