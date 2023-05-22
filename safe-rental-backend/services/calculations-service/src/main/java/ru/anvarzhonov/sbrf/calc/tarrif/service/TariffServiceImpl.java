package ru.anvarzhonov.sbrf.calc.tarrif.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.sbrf.calc.tarrif.entities.Tariff;
import ru.anvarzhonov.sbrf.calc.tarrif.repository.TariffRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffServiceImpl implements TariffService {
    private final TariffRepository repository;
    @Override
    public BigDecimal getPricePerDayRentalPeriod(int dayPeriod) {
        return null;
    }
    @Override
    public List<Tariff> geTariffs() {
        return repository.findAll();
    }
}
