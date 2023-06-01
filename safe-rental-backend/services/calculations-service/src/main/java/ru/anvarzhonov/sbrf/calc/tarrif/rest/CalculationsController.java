package ru.anvarzhonov.sbrf.calc.tarrif.rest;

import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
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
    @GetMapping("/executeCalc")
    public BaseApiResponse getCalculatedRent(@RequestBody ValueInstantiators.Base request) {
        var response = executeCalculateRent(request);
        return BaseApiResponse.builder().build();
    }


    private String executeCalculateRent(ValueInstantiators.Base b){
        return null;
    }
}
