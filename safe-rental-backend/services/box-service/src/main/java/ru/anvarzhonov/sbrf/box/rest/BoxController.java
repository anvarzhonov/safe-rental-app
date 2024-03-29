package ru.anvarzhonov.sbrf.box.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.box.request.GetSafesForOfficesRq;
import ru.anvarzhonov.sbrf.box.request.UpdateStatusRq;
import ru.anvarzhonov.sbrf.box.response.GetSafeInfoByIdResponse;
import ru.anvarzhonov.sbrf.box.response.GetSafesForOfficesResponse;
import ru.anvarzhonov.sbrf.box.service.BoxService;

@RestController
@RequestMapping("/box")
@Slf4j
@RequiredArgsConstructor
public class BoxController {
    private final BoxService service;

    @PostMapping("/getSafesForOffices")
    public GetSafesForOfficesResponse getSafesForOffices(@RequestBody GetSafesForOfficesRq request) {
        var safesForOfficeIds = service.getSafesForOfficeId(request.getOfficeId());
        return GetSafesForOfficesResponse.builder()
                .data(safesForOfficeIds)
                .build();
    }

    @GetMapping("/{safeId}")
    public GetSafeInfoByIdResponse getSafeInfo(@PathVariable Long safeId) {
        log.info("Получение данных о сейфе. --> safeId: {}", safeId);
        var safeInfo = service.getSafeInfo(safeId);
        log.info("Получение данных о сейфе, <-- safeDto: {}", safeInfo);
        return GetSafeInfoByIdResponse.builder()
                .status(BaseApiResponse.Status.OK)
                .safeInfo(safeInfo)
                .build();
    }

    @PostMapping("/updateStatus")
    public BaseApiResponse updateSafeStatus(@RequestBody UpdateStatusRq request) {
        log.info("Запрос на изменение статуса у сейфа. request: {}", request);
        service.updateStatus(request.getSafeId(), request.getStatus());
        return BaseApiResponse.builder().status(BaseApiResponse.Status.OK).build();
    }

    @ExceptionHandler({BusinessException.class, Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        var response = new BaseApiResponse();
        response.setStatus(BaseApiResponse.Status.ERROR);
        response.setErrMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
