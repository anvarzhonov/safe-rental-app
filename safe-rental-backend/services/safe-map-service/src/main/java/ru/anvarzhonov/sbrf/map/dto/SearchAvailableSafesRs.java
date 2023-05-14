package ru.anvarzhonov.sbrf.map.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class SearchAvailableSafesRs {
    private List<OfficeDto> offices;
}
