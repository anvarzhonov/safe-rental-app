package ru.anvarzhonov.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AgreementDetails {
    private LocalDate rentEndDate;
    private Long safeId;
}
