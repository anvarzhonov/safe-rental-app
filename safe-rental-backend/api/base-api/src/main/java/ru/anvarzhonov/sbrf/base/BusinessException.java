package ru.anvarzhonov.sbrf.base;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
