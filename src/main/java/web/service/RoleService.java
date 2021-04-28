package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(int id);

    Role saveRole(Role role);

    void deleteRole(int id);

    List<Role> getRoles(String[] arr);
}
