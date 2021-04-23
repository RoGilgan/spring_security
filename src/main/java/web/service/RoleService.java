package web.service;

import web.model.Role;

public interface RoleService {

    Role getRoleById(int id);

    Role saveRole(Role role);

    void deleteRole(int id);
}
