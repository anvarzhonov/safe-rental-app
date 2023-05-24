package ru.anvarzhonov.sbrf.base.rest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class BaseApiResponse implements Serializable {
//    @JsonUnwrapped
    private Status status;
    private String errMessage;

//    private T data;

    public BaseApiResponse() {
        this.status = Status.OK;
    }
//    public BaseApiResponse(T data) {
//        this.status = Status.OK;
//        this.data = data;
//    }

    public BaseApiResponse(Status status, String errMessage) {
        this.status = status;
        this.errMessage = errMessage;
    }


    public enum Status {
        OK,
        ERROR
    }
}
