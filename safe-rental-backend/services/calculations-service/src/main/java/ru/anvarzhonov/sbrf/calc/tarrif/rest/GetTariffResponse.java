package ru.anvarzhonov.sbrf.calc.tarrif.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.anvarzhonov.sbrf.calc.tarrif.entities.Tariff;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTariffResponse implements Serializable {
    private List<Tariff> tariffs;
}
