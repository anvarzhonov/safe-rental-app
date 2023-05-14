package ru.anvarzhonov.sbrf.map.dto;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class AvailableSafesDto {
    Long id;
    String size;
}
