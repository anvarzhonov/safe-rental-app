package ru.anvarzhonov.sbrf.calc.tarrif.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.sbrf.calc.tarrif.entities.Tariff;
import ru.anvarzhonov.sbrf.calc.tarrif.service.TariffService;

import java.util.List;

@RestController
@RequestMapping("/calc")
@RequiredArgsConstructor
public class CalculationsController {
    private final TariffService service;
    @GetMapping("/getTariffs")
    public GetTariffResponse getAllTariffs() {
        List<Tariff> tariffs = service.geTariffs();
        return GetTariffResponse
                .builder()
                    .tariffs(tariffs)
                    .build();
    }
}
