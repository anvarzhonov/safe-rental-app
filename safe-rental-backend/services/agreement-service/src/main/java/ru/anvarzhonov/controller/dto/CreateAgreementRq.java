package ru.anvarzhonov.controller.dto;

import lombok.Data;

@Data
public class CreateAgreementRq {
    private AgreementDetails agreementDetails;
    private PaymentDetails paymentDetails;
}
