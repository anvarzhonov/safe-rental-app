package ru.anvarzhonov.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.client.UserServiceClient;
import ru.anvarzhonov.dto.AuthRequest;
import ru.anvarzhonov.dto.SignInRequest;
import ru.anvarzhonov.mapper.UserMapper;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.user.response.CreateNewUserResponse;
import ru.anvarzhonov.utils.JwtUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final UserServiceClient userServiceClient;
    private final JwtUtils jwt;
    @Override
    public String registerUser(AuthRequest request) {
        var userServiceRq = userMapper.authRequestToCreateNewUserRequest(request);
        CreateNewUserResponse userServiceResponse = userServiceClient.createNewUser(userServiceRq);

        if (userServiceResponse.getStatus().equals(BaseApiResponse.Status.ERROR)) {
            throw new BusinessException(userServiceResponse.getErrMessage());
        }

        return jwt.generateToken(String.valueOf(userServiceResponse.getCreatedUserId()));
    }

    @Override
    public String signInUser(SignInRequest request) {
        var validateUserCredentialsRq = userMapper.signInRequestToValidateUserCredRequest(request);
        var validateUserCredentialsRs = userServiceClient.validateUser(validateUserCredentialsRq);

        if (validateUserCredentialsRs.getStatus().equals(BaseApiResponse.Status.ERROR)) {
            throw new BusinessException(validateUserCredentialsRs.getErrMessage());
        }

        return jwt.generateToken(request.getUsername());
    }
}
