package ru.anvarzhonov.sbrf.box.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anvarzhonov.sbrf.box.request.GetSafesForOfficesRq;
import ru.anvarzhonov.sbrf.box.response.GetSafesForOfficesRs;
import ru.anvarzhonov.sbrf.box.service.BoxService;

@RestController
@RequestMapping("/box")
@Slf4j
@RequiredArgsConstructor
public class BoxController {
    private final BoxService service;

    @PostMapping("/getSafesForOffices")
    public GetSafesForOfficesRs getSafesForOffices(@RequestBody GetSafesForOfficesRq request) {
        var safesForOfficeIds = service.getSafesForOfficeId(request.getOfficeId());
        return GetSafesForOfficesRs.builder()
                    .data(safesForOfficeIds)
                    .build();
    }
}
