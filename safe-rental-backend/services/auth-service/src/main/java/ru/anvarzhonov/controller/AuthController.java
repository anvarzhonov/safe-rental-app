package ru.anvarzhonov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.dto.AuthRequest;
import ru.anvarzhonov.dto.AuthResponse;
import ru.anvarzhonov.dto.SignInRequest;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.service.AuthService;

import static java.lang.String.format;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private static final String SERVICE_NAME = "auth-service";
    private final AuthService service;
    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody AuthRequest request) {
        log.info("[{}] Register new user --> request: {}", SERVICE_NAME, request);
        try {
            service.registerUser(request);
            log.info("[{}] Register new user <-- Пользователь с username {} успешно создан", SERVICE_NAME,
                    request.getUsername());

            return ResponseEntity.status(HttpStatus.CREATED).body(format("Пользователь с username %s успешно создан",
                    request.getUsername()));
        } catch (BusinessException ex) {
            log.info("[{}] Register new user <-- Error. Error Message: {}", SERVICE_NAME, ex.getMessage());
            return ResponseEntity.badRequest().body(BaseApiResponse.builder()
                                                        .errMessage(ex.getMessage()).build());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@RequestBody SignInRequest request) {
        log.info("[{}] Sign in user --> request: {}", SERVICE_NAME, request);
        try {
            String authToken = service.signInUser(request);
            log.info("[{}] Sign in user <-- generatedJwtToken: {}", SERVICE_NAME, authToken);
            return ResponseEntity.ok(new AuthResponse(authToken));
        } catch (BusinessException ex) {
            log.info("[{}] Sign in user <-- Error. Error Message: {}", SERVICE_NAME, ex.getMessage());
            return ResponseEntity.badRequest().body(BaseApiResponse.builder()
                    .status(BaseApiResponse.Status.ERROR)
                    .errMessage(ex.getMessage()).build());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

}
