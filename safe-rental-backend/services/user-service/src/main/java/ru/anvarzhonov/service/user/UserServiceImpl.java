package ru.anvarzhonov.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.entity.Role;
import ru.anvarzhonov.entity.RoleName;
import ru.anvarzhonov.entity.User;
import ru.anvarzhonov.exceptions.UserAlreadyExistException;
import ru.anvarzhonov.repository.UserRepository;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.user.request.CreateNewUserRequest;
import ru.anvarzhonov.sbrf.user.request.ValidateUserCredentialsRequest;
import ru.anvarzhonov.service.role.RoleService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final RoleService roleService;
    private final UserRepository repository;
    @Override
    public User createNewUser(CreateNewUserRequest request) {
        String username = request.getUsername();
        Boolean isUserExist = repository.existsByUsername(username);

        if (isUserExist) {
            throw new UserAlreadyExistException("Пользователь с username: " + username + " уже существует.");
        }

        User user = User.builder()
                .username(username)
                .password(encoder.encode(request.getPassword()))
                .roles(Set.of(getUserRole()))
                .build();

        return repository.save(user);
    }

    @Override
    public void validateUserCred(ValidateUserCredentialsRequest request) {
        String username = request.getUsername();
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new BusinessException("Пользователь с username - " + username + " не найден"));

        String storedPassword = user.getPassword(); // hashed password, stored in db.
        if (!encoder.matches(request.getPassword(), storedPassword)) {
            throw new BusinessException(String.format("Пароль для пользователя - %s не корректен.", username));
        }
    }

    private Role getUserRole() {
        return roleService.getByRoleName(RoleName.ROLE_USER);
    }
}
