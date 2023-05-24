package ru.anvarzhonov.sbrf.box.dto;

import java.math.BigDecimal;

public record SafeDto(Long safeId, SafeStatus status, String size, BigDecimal pricePerDay) {
}
