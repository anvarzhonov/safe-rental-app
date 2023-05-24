package ru.anvarzhonov.sbrf.box.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSafesForOfficesResponse implements Serializable {
    SafesWithOfficeIdDto data;
}
