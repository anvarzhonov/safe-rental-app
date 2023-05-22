package ru.anvarzhonov.sbrf.calc.tarrif.service;

import ru.anvarzhonov.sbrf.calc.tarrif.entities.Tariff;

import java.math.BigDecimal;
import java.util.List;

/**
 * Интерфейс сервиса работы с тарифной сеткой
 */
public interface TariffService {
    /**
     * Получить сумму аренды сейфа за выбранный срок в зависимости от тарифа
     */
    BigDecimal getPricePerDayRentalPeriod(int dayPeriod);

    /**
     * Получить список тарифов {@link Tariff}
     * @return список тарифов
     */
    List<Tariff> geTariffs();

}
