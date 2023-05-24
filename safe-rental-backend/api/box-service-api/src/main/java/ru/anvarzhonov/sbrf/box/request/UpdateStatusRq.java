package ru.anvarzhonov.sbrf.box.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStatusRq {
    private Long safeId;
    private SafeStatus status;
}
