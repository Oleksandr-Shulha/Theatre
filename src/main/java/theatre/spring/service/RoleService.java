package theatre.spring.service;

import theatre.spring.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(Role.RoleName roleName);
}
