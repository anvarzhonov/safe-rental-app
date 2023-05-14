package ru.anvarzhonov.service.role;

import ru.anvarzhonov.entity.Role;
import ru.anvarzhonov.entity.RoleName;

public interface RoleService {

    Role getByRoleName(RoleName name);
}
