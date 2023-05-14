package ru.anvarzhonov.sbrf.box.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;
import ru.anvarzhonov.sbrf.box.entities.Safe;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SafeMapper {
    List<SafesWithOfficeIdDto.SafeWithSafeIdAndSafeSize> safeEntitiesToSafes(List<Safe> safes);
    @Mapping(target = "safeId", source ="id")
    @Mapping(target = "safeSize", source ="safeType.size")
    SafesWithOfficeIdDto.SafeWithSafeIdAndSafeSize safeEntityToSafesWithOfficeIdDto(Safe safe);
}
