package ru.anvarzhonov.sbrf.box.service;

import ru.anvarzhonov.sbrf.box.dto.SafeStatus;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;

/**
 * Интерфейс сервиса работы с сейфовыми ячейками
 */
public interface BoxService {
    SafesWithOfficeIdDto getSafesForOfficeId(Long officeId);
    void updateStatus(Long safeId, SafeStatus status);
}
