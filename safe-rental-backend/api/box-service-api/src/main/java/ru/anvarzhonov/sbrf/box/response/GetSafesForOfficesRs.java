package ru.anvarzhonov.sbrf.box.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.anvarzhonov.sbrf.box.dto.SafesWithOfficeIdDto;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSafesForOfficesRs implements Serializable {
    SafesWithOfficeIdDto data;
}
