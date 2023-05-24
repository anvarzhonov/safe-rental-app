package ru.anvarzhonov.service;

import ru.anvarzhonov.controller.dto.AgreementDetails;

public interface AgreementService {
    /**
     * Создать новый договор аренды
     * @param username имя пользователя
     * @param agreementDetails детали о договоре
     * @return сохраненный номер договора
     */
    String createAgreement(String username, AgreementDetails agreementDetails);
}
