package ru.anvarzhonov.service.user;

import ru.anvarzhonov.entity.User;
import ru.anvarzhonov.sbrf.user.request.CreateNewUserRequest;
import ru.anvarzhonov.sbrf.user.request.ValidateUserCredentialsRequest;

public interface UserService {

    User createNewUser(CreateNewUserRequest request);

    void validateUserCred(ValidateUserCredentialsRequest request);
}
