package ru.anvarzhonov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.controller.dto.AgreementDetails;
import ru.anvarzhonov.entity.Agreement;
import ru.anvarzhonov.mapper.AgreementMapper;
import ru.anvarzhonov.repository.AgreementRepository;
import ru.anvarzhonov.sbrf.base.BusinessException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {
    private final AgreementMapper mapper;
    private final AgreementRepository repository;

    @Override
    public String createAgreement(String username, AgreementDetails agreementDetails) {
        Agreement agreement = mapper.agreementDetailsToAgreement(agreementDetails);
        LocalDate now = LocalDate.now();

        String agreementNumber = createAgreementNumber(username, agreement.getSafeId(), now);

        if (repository.findByAgreementNumber(agreementNumber).isPresent()) {
          throw new BusinessException("Номер договора (" + agreementNumber + ") уже существует");
        }

        Agreement finalAgreement = agreement.toBuilder()
                .username(username)
                .startDate(now)
                .agreementNumber(agreementNumber)
                .build();

        Agreement saved = repository.save(finalAgreement);
        return saved.getAgreementNumber();
    }

    // Agreement number example: mirzoev.3.24-03-2022
    private String createAgreementNumber(String username, Long safeId, LocalDate rentStartDate) {
        String formattedAgreementNumber = "%s.%s.%s";
        return String.format(formattedAgreementNumber, username, safeId, rentStartDate);
    }
}
