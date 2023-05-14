package ru.anvarzhonov.sbrf.map.dto;

import java.util.List;

public interface OfficeView {
    Long getId();
    String getAddress();

    //    LocalDateTime getOpenAt();
//    @Value("#{new ru.anvarzhonov.saferentalbackend.mapSearch.dto.OfficeView.Coordinate(target.latitudeCoordinate, target.longitudeCoordinate)}")
//    Coordinate getCoordinate();
//
////    @Value("#{new ru.anvarzhonov.saferentalbackend.mapSearch.dto.AvailableSafesDto(target.safeId, target.safeType.size)}")
//    List<AvailableSafesView> getSafes();

    //
    interface AvailableSafesView {
        Long getId();
//    SafeType.Size getSize();
    }

}
