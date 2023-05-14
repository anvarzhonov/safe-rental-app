package ru.anvarzhonov.sbrf.box.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anvarzhonov.sbrf.box.entities.Safe;
import ru.anvarzhonov.sbrf.box.entities.SafeType;

@Repository
public interface BoxTypeRepository extends JpaRepository<SafeType, Long> {

//    Safe findByOfficeId(Long officeId);
}
