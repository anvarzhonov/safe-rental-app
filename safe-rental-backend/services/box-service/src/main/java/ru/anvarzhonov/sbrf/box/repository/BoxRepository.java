package ru.anvarzhonov.sbrf.box.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.sbrf.box.entities.Safe;

import java.util.List;

@Repository
public interface BoxRepository extends JpaRepository<Safe, Long> {

    List<Safe> findByOfficeId(Long officeId);
}
