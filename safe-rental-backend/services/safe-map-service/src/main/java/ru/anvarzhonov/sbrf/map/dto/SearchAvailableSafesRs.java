package ru.anvarzhonov.sbrf.map.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;

import java.util.List;

@SuperBuilder
@Getter
@ToString
@Setter
public class SearchAvailableSafesRs extends BaseApiResponse {
    private List<OfficeDto> offices;
}
