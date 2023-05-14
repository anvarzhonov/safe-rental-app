package ru.anvarzhonov.sbrf.box.request;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSafesForOfficesRq implements Serializable {
    private Long officeId;
}
