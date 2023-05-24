package ru.anvarzhonov.sbrf.box.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.box.dto.SafeDto;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetSafeInfoByIdResponse extends BaseApiResponse {
    private SafeDto safeInfo;
}
