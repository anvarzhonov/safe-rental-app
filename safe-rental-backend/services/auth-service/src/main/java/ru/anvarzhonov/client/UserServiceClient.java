package ru.anvarzhonov.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.anvarzhonov.sbrf.user.request.CreateNewUserRequest;
import ru.anvarzhonov.sbrf.user.request.ValidateUserCredentialsRequest;
import ru.anvarzhonov.sbrf.user.response.CreateNewUserResponse;
import ru.anvarzhonov.sbrf.user.response.ValidateUserCredentialsResponse;

@Service
@RequiredArgsConstructor
public class UserServiceClient {
    @Value("${services.user-service.url}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    public CreateNewUserResponse createNewUser(CreateNewUserRequest request) {
        return restTemplate.postForObject(baseUrl + "/users", request, CreateNewUserResponse.class);
    }

    public ValidateUserCredentialsResponse validateUser(ValidateUserCredentialsRequest request) {
        return restTemplate.postForObject(baseUrl + "/users/validate", request, ValidateUserCredentialsResponse.class);
    }
}
