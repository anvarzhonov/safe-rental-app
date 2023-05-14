package ru.anvarzhonov.sbrf.box.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.anvarzhonov.sbrf.box.dto.SafeTypePrices;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SafeTypePricesResponse implements Serializable {
    List<SafeTypePrices> data;
}
