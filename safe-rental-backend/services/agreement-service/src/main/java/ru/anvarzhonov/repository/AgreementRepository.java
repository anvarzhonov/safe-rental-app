package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anvarzhonov.entity.Agreement;

import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    Optional<Agreement> findByAgreementNumber(String agreementNumber);
}