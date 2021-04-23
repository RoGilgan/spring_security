package web.dao;

import web.model.Role;

public interface RoleDao {

    Role getRoleById(int id);

    Role saveRole(Role role);

    void deleteRole(int id);
}
