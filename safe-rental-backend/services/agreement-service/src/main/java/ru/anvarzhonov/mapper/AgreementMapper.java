package ru.anvarzhonov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.anvarzhonov.controller.dto.AgreementDetails;
import ru.anvarzhonov.controller.dto.AgreementInfoDto;
import ru.anvarzhonov.entity.Agreement;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    @Mapping(target = "endDate", source = "rentEndDate")
    Agreement agreementDetailsToAgreement(AgreementDetails agreementDetails);

    @Mapping(target = "rentStartDate", source = "agreement.startDate")
    @Mapping(target = "rentEndDate", source = "agreement.endDate")
    AgreementInfoDto agreementInfoToAgreementDto(Agreement agreement, String safeSize);
}
