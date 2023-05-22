package ru.anvarzhonov.sbrf.calc.tarrif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.sbrf.calc.tarrif.entities.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
