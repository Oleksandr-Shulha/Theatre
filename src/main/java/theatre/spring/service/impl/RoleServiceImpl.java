package theatre.spring.service.impl;

import org.springframework.stereotype.Service;
import theatre.spring.dao.RoleDao;
import theatre.spring.exception.DataProcessingException;
import theatre.spring.model.Role;
import theatre.spring.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(
                () -> new DataProcessingException("Role: " + roleName + " not found"));
    }
}
