package ru.anvarzhonov.sbrf.map.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.sbrf.map.dto.SearchAvailableSafesRs;
import ru.anvarzhonov.sbrf.map.service.MapSearchService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/map")
@Slf4j
public class MapSearchController {
    private final MapSearchService service;

    @GetMapping("/findOfficesWithAvailableSafes")
    public SearchAvailableSafesRs findOfficesWithAvailableSafes() {
        var availableSafes = service.findAvailableSafes();
        log.info("Offices with availableSafes: <-- {}", availableSafes.size());
        return SearchAvailableSafesRs
                .builder()
                    .offices(availableSafes)
                    .build();
    }
}
