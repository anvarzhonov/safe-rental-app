package ru.anvarzhonov.sbrf.box.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;
import ru.anvarzhonov.sbrf.box.mapper.SafeMapper;
import ru.anvarzhonov.sbrf.box.repository.BoxRepository;

@Service
@RequiredArgsConstructor
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
}
