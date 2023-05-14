package ru.anvarzhonov.sbrf.base.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseApiResponse implements Serializable {
    private Status status = Status.OK;
    private String errMessage;

    public enum Status {
        OK,
        ERROR
    }
}
