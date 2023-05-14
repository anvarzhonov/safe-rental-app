package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JacksonTest {

    @Test
    void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = Files.readString(Paths.get("src/test/resources/Chef.json"));
        FoodEstablishment foodEstablishment = mapper.readValue(s, FoodEstablishment.class);

        System.out.println(foodEstablishment);
    }

    @Test
    void test2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(FoodEstablishment.Chef.class, FoodMixIn.class);
        mapper.addMixIn(FoodEstablishment.AntonioChef.class, FoodMixIn2.class);
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);

        var r = new FoodEstablishment();
        r.setChefs(List.of(
                FoodEstablishment.AntonioChef.builder().name("Antonio").build(),
                FoodEstablishment.MarcoChef.builder().name("Marco").build()));

        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(r);

        FoodEstablishment.AntonioChef antonio = FoodEstablishment.AntonioChef.builder().name("Antonio").build();

//        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(antonio);
        System.out.println(s);
    }
}
