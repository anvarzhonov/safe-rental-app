package ru.anvarzhonov.sbrf.box.service.type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.sbrf.box.dto.SafeTypePrices;
import ru.anvarzhonov.sbrf.box.entities.SafeType;
import ru.anvarzhonov.sbrf.box.mapper.SafeTypeMapper;
import ru.anvarzhonov.sbrf.box.repository.BoxTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoxTypeServiceImpl implements BoxTypeService {
    private final SafeTypeMapper mapper;
    private final BoxTypeRepository repository;
    @Override
    public List<SafeTypePrices> getPricePerDayForSizes() {
        List<SafeType> safeTypes = repository.findAll();
        return mapper.safeTypeEntitiesToListDto(safeTypes);
    }
}
