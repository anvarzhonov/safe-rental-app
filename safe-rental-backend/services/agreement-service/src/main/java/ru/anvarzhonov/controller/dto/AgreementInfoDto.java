package ru.anvarzhonov.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AgreementInfoDto {
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private String agreementNumber;

    private String safeSize;
}
