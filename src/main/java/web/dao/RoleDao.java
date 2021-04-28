package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDao {

    Role getRoleById(int id);

    Role saveRole(Role role);

    void deleteRole(int id);

    List<Role> getRoles(String[] arr);


}
