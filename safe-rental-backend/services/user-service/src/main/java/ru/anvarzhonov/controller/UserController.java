package ru.anvarzhonov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.entity.User;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.user.request.CreateNewUserRequest;
import ru.anvarzhonov.sbrf.user.request.ValidateUserCredentialsRequest;
import ru.anvarzhonov.sbrf.user.response.CreateNewUserResponse;
import ru.anvarzhonov.sbrf.user.response.ValidateUserCredentialsResponse;
import ru.anvarzhonov.service.user.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping()
    public CreateNewUserResponse createNewUser(@RequestBody CreateNewUserRequest request) {
        String serviceName = "Register new user request.";
        log.info("[{}] --> {}", serviceName, request);
        var responseBuilder = CreateNewUserResponse.builder();
        User newUser;
        try {
            newUser = service.createNewUser(request);
        } catch (BusinessException ex) {
            log.error("[{}] Error. <-- Error message: {}", serviceName, ex.getMessage());
            return responseBuilder
                    .status(BaseApiResponse.Status.ERROR)
                    .errMessage(ex.getMessage())
                    .build();
        }
        log.info("[{}] Success. <-- {}", serviceName, newUser);
        return responseBuilder
                .status(BaseApiResponse.Status.OK)
                .createdUserId(newUser.getId())
                .build();
    }

    @PostMapping("/validate")
    public ValidateUserCredentialsResponse validateUser(@RequestBody ValidateUserCredentialsRequest request) {
        String serviceName = "Validate user credentials";
        try {
            log.info("[{}] request -> {}", serviceName, request);
            service.validateUserCred(request);
        } catch (BusinessException e) {
            log.info("[{}] Business Error: {}", serviceName, e.getMessage());
            return ValidateUserCredentialsResponse.builder()
                                .status(BaseApiResponse.Status.ERROR)
                                .errMessage(e.getMessage())
                                .build();
        }
        log.info("[{}] Success.", serviceName);
        return ValidateUserCredentialsResponse.builder()
                .status(BaseApiResponse.Status.OK)
                .build();
    }
}
