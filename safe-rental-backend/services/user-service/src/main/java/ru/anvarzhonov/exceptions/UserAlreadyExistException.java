package ru.anvarzhonov.exceptions;

import ru.anvarzhonov.sbrf.base.BusinessException;

public class UserAlreadyExistException extends BusinessException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
