package ru.anvarzhonov.sbrf.box.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SafesWithOfficeIdDto implements Serializable {
    Long officeId;
    List<SafeWithSafeIdAndSafeSize> safes;
    public record SafeWithSafeIdAndSafeSize(Long safeId, String safeSize){}
}
