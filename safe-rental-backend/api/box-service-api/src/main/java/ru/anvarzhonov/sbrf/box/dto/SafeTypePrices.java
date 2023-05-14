package ru.anvarzhonov.sbrf.box.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SafeTypePrices implements Serializable {
    private String size;
    private BigDecimal priceOfDay;
}
