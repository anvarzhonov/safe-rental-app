package ru.anvarzhonov.sbrf.box.mapper;

import ru.anvarzhonov.sbrf.box.dto.SafeTypePrices;
import ru.anvarzhonov.sbrf.box.entities.SafeType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SafeTypeMapper {
    List<SafeTypePrices> safeTypeEntitiesToListDto(List<SafeType> safeType);
    SafeTypePrices safeTypeToSafeTypePricesMapper(SafeType safeType);
}
