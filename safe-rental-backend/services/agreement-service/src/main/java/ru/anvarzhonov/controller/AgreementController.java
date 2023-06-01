package ru.anvarzhonov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anvarzhonov.controller.dto.AgreementDetails;
import ru.anvarzhonov.controller.dto.AgreementInfoDto;
import ru.anvarzhonov.controller.dto.CreateAgreementRq;
import ru.anvarzhonov.controller.dto.CreateAgreementRs;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.box.dto.SafeDto;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;
import ru.anvarzhonov.service.AgreementService;
import ru.anvarzhonov.service.box.BoxService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agreement")
@RequiredArgsConstructor
@Slf4j
public class AgreementController {
    private final AgreementService service;
    private final BoxService boxService;

    @PostMapping("/")
    public ResponseEntity<CreateAgreementRs> createNewAgreement(@RequestHeader("username") String currentUserName,
                                                                @RequestBody CreateAgreementRq request) {
        log.info("Создание нового договора. --> Username: {}, rq: {}", currentUserName, request);
        AgreementDetails agreementDetails = request.getAgreementDetails();

        if (agreementDetails.getRentEndDate().isBefore(LocalDate.now())) {
            throw new BusinessException("Дата окончания аренды не может быть меньше текущего дня");
        }

        Long safeId = agreementDetails.getSafeId();
        SafeDto safeDto = boxService.executeGetSafeInfoById(safeId);

        if (!safeDto.status().equals(SafeStatus.FREE)) {
            throw new BusinessException("Сейф с id: " + safeId + " уже забронирован.");
        }

        String agreementNumber = service.createAgreement(currentUserName, request.getAgreementDetails());
        boxService.executeUpdateSafeStatus(safeId, SafeStatus.RESERVED);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                CreateAgreementRs.builder()
                        .status(BaseApiResponse.Status.OK)
                        .agreementNumber(agreementNumber)
                        .build());
    }

    @GetMapping("/get")
    public List<AgreementInfoDto> getAgreements(@RequestHeader("username") String username) {
        return service.getAgreements(username);
    }

    @ExceptionHandler({BusinessException.class, Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        var response = new BaseApiResponse();
        response.setStatus(BaseApiResponse.Status.ERROR);
        response.setErrMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
