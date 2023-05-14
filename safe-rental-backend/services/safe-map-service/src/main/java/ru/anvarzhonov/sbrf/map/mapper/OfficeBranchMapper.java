package ru.anvarzhonov.sbrf.map.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.anvarzhonov.sbrf.map.entities.OfficeBranch;
import ru.anvarzhonov.sbrf.map.dto.OfficeDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeBranchMapper {

    List<OfficeDto> officeEntitiesToOfficeDtos(List<OfficeBranch> officeBranchList);

    @Mapping(target = "address", source = "address")
    @Mapping(target = "coordinate.latitudeCoordinate", source = "latitudeCoordinate")
    @Mapping(target = "coordinate.longitudeCoordinate", source = "longitudeCoordinate")
    OfficeDto officeEntityToOfficeDto(OfficeBranch officeBranch);
}
