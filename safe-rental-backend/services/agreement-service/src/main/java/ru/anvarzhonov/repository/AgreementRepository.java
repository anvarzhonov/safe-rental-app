package ru.anvarzhonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anvarzhonov.entity.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    List<Agreement> findByUsername(String username);
    Optional<Agreement> findByAgreementNumber(String agreementNumber);
}