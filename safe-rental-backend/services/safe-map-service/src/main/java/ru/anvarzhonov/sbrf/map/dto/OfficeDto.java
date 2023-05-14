package ru.anvarzhonov.sbrf.map.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Value;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;

import java.util.List;

@Builder
@Data
public class OfficeDto {
    Long id;
    String address;
    //    LocalDateTime openAt;
    Coordinate coordinate;
    List<SafesWithOfficeIdDto.SafeWithSafeIdAndSafeSize> safes;

    public record Coordinate(Float latitudeCoordinate, Float longitudeCoordinate) {
    }
}
//public interface OfficeView {
//    String getAddress();
////    LocalDateTime getOpenAt();
//    @Value("#{new ru.anvarzhonov.saferentalbackend.mapSearch.dto.OfficeView.Coordinate(target.latitudeCoordinate, target.longitudeCoordinate)}")
//    Coordinate getCoordinate();
////
//////    @Value("#{new ru.anvarzhonov.saferentalbackend.mapSearch.dto.AvailableSafesDto(target.safeId, target.safeType.size)}")
////    List<AvailableSafesView> getSafes();
////
//    interface AvailableSafesView {
//    Long getId();
//
//    SafeType.Size getSize();
//}
//}

