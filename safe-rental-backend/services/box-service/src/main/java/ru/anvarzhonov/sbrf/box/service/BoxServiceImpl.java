package ru.anvarzhonov.sbrf.box.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;
import ru.anvarzhonov.sbrf.box.entities.Safe;
import ru.anvarzhonov.sbrf.box.mapper.SafeMapper;
import ru.anvarzhonov.sbrf.box.repository.BoxRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoxServiceImpl implements BoxService {
    private final BoxRepository boxRepository;
    private final SafeMapper mapper;

    @Override
    public SafesWithOfficeIdDto getSafesForOfficeId(Long officeId) {

        var safeEntities = boxRepository.findByOfficeId(officeId);

        return SafesWithOfficeIdDto.builder()
                .officeId(officeId)
                .safes(mapper.safeEntitiesToSafes(safeEntities))
                .build();

    }

    @Override
    public void updateStatus(Long safeId, SafeStatus status) {
        Safe safe = boxRepository.findById(safeId).orElseThrow(() -> {
            String errMessage = "Safe с id - (%s) не найден.";
            throw new BusinessException(String.format(errMessage, safeId));
        });
        SafeStatus currentStatus = safe.getStatus();
        safe.setStatus(status);

        boxRepository.save(safe);
        log.info("Изменился статус у сейфа с id - ({}) c - ({}) на ({})", safeId, currentStatus, status);
    }
}
