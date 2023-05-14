package ru.anvarzhonov.mapper;

import org.mapstruct.Mapper;
import ru.anvarzhonov.dto.AuthRequest;
import ru.anvarzhonov.dto.SignInRequest;
import ru.anvarzhonov.sbrf.user.request.CreateNewUserRequest;
import ru.anvarzhonov.sbrf.user.request.ValidateUserCredentialsRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {
    CreateNewUserRequest authRequestToCreateNewUserRequest(AuthRequest request);
    ValidateUserCredentialsRequest signInRequestToValidateUserCredRequest(SignInRequest request);
}
