package ru.anvarzhonov.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDetails {
    private BigDecimal totalAmount;
    private int countRentDays;
}
