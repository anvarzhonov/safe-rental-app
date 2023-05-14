package ru.anvarzhonov.sbrf.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.anvarzhonov.sbrf.map.dto.OfficeView;
import ru.anvarzhonov.sbrf.map.entities.OfficeBranch;

import java.util.List;

public interface OfficeBranchRepository extends JpaRepository<OfficeBranch, Long> {

//    @Query("""
//            select new ru.anvarzhonov.saferentalbackend.mapSearch.dto.OfficeDto(
//            o.address)
//            from OfficeBranch o
//                                left join o.safes s
//                                left join s.safeType t
//            """)

//    @Query("""
//            select o.address,  from OfficeBranch o left join Safe s
//            """)
//    List<OfficeView> findAllIds();

//    @Query("""
//            select o from OfficeBranch o join fetch o.safes s join fetch s.safeType t
//            """)
//    List<OfficeBranch> findAllWithAvailableSafes();
}