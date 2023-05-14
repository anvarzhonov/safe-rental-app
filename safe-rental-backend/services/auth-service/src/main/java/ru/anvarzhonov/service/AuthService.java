package ru.anvarzhonov.service;

import ru.anvarzhonov.dto.AuthRequest;
import ru.anvarzhonov.dto.SignInRequest;

public interface AuthService {
    String registerUser(AuthRequest request);

    String signInUser(SignInRequest request);
}
