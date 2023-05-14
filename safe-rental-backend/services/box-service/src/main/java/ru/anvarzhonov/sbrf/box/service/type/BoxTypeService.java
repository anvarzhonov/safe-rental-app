package ru.anvarzhonov.sbrf.box.service.type;

import ru.anvarzhonov.sbrf.box.dto.SafeTypePrices;

import java.util.List;

/**
 * Интерфейс сервиса работы с сейфовыми ячейками
 */
public interface BoxTypeService {
    /**
     * Получить список {@link SafeTypePrices} с типом сейфа и его ценой за один день
     *
     * @return {@link SafeTypePrices}
     */
    List<SafeTypePrices> getPricePerDayForSizes();

}
