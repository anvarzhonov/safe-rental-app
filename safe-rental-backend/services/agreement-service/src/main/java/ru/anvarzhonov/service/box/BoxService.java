package ru.anvarzhonov.service.box;

import ru.anvarzhonov.sbrf.box.dto.SafeDto;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;

public interface BoxService {
    void executeUpdateSafeStatus(Long safeId, SafeStatus status);

    SafeDto executeGetSafeInfoById(Long safeId);
}
