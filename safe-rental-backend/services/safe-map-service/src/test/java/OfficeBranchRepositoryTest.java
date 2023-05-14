//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import ru.anvarzhonov.sbrf.map.entities.OfficeBranch;
//import ru.anvarzhonov.sbrf.map.repository.OfficeBranchRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//class OfficeBranchRepositoryTest {
//    @Autowired private OfficeBranchRepository repository;
//
//    @Test
//    void findAllBy() {
//        var allBy = repository.findAllBy();
//
//        assertNotNull(allBy);
////        allBy.forEach(System.out::println);
//        System.out.println(allBy);
//    }
//
//    @Test
//    void findAll() {
//        List<OfficeBranch> all = repository.findAll();
//        all.forEach(System.out::println);
//    }
//
//    @Test
//    void findAllAvailableSafes() {
//        var all = repository.findAllWithAvailableSafes();
//        System.out.println(all);
//        System.out.println("===========");
//        all.forEach(x -> {
//            System.out.println(x.getAddress());
//            x.getSafes().forEach(System.out::println);
//        });
//    }
//}