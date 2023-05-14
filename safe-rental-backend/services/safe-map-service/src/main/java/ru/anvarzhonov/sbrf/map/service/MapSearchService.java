package ru.anvarzhonov.sbrf.map.service;

import ru.anvarzhonov.sbrf.map.dto.OfficeDto;

import java.util.List;

public interface MapSearchService {
    List<OfficeDto> findAvailableSafes();
}
