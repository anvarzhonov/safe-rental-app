package ru.anvarzhonov.sbrf.box.service;

import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;

import java.util.List;

/**
 * Интерфейс сервиса работы с сейфовыми ячейками
 */
public interface BoxService {
    SafesWithOfficeIdDto getSafesForOfficeId(Long officeId);
}
