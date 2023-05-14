package ru.anvarzhonov.service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.entity.Role;
import ru.anvarzhonov.entity.RoleName;
import ru.anvarzhonov.repository.RoleRepository;
import ru.anvarzhonov.sbrf.base.BusinessException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Override
    public Role getByRoleName(RoleName name) {
        return repository.findByName(name)
                .orElseThrow(() -> new BusinessException("User Role not set."));
    }
}
