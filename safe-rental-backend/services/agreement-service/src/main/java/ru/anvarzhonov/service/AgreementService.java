package ru.anvarzhonov.service;

import ru.anvarzhonov.controller.dto.AgreementDetails;
import ru.anvarzhonov.controller.dto.AgreementInfoDto;

import java.util.List;

public interface AgreementService {
    /**
     * Создать новый договор аренды
     * @param username имя пользователя
     * @param agreementDetails детали о договоре
     * @return сохраненный номер договора
     */
    String createAgreement(String username, AgreementDetails agreementDetails);

    /**
     * Получение договоров по имени пользователя
     *
     * @param username имя пользователя
     * @return
     */
    List<AgreementInfoDto> getAgreements(String username);
}
