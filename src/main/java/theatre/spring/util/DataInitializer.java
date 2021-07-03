package theatre.spring.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import theatre.spring.model.Role;
import theatre.spring.model.User;
import theatre.spring.service.RoleService;
import theatre.spring.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        roleService.add(new Role(Role.RoleName.ROLE_ADMIN));
        roleService.add(new Role(Role.RoleName.ROLE_USER));

        User bob = new User();
        bob.setEmail("user@gmail.com");
        bob.setPassword("123456789u");
        bob.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_USER)));
        userService.add(bob);

        User alice = new User();
        alice.setEmail("admin@gmail.com");
        alice.setPassword("1234556789a");
        alice.setRoles(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_ADMIN)));
        userService.add(alice);
    }
}
