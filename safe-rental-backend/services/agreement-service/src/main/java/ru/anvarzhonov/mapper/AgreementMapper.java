package ru.anvarzhonov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.anvarzhonov.controller.dto.AgreementDetails;
import ru.anvarzhonov.entity.Agreement;

@Mapper(componentModel = "spring")
public interface AgreementMapper {
    @Mapping(target = "endDate", source = "rentEndDate")
    Agreement agreementDetailsToAgreement(AgreementDetails agreementDetails);
}
