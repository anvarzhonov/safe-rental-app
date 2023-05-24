package ru.anvarzhonov.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAgreementRs extends BaseApiResponse {
    private String agreementNumber;
}
