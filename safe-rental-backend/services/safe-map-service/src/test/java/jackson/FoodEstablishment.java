package jackson;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodEstablishment {

    private List<Chef> chefs;
    private int lotation;

//    @JsonTypeInfo(
//            use = JsonTypeInfo.Id.CLASS,
//            include = JsonTypeInfo.As.PROPERTY,
//    property = "className")
//    @JsonSubTypes({
//            @JsonSubTypes.Type(value = AntonioChef.class, name = "Antonio"),
//            @JsonSubTypes.Type(value = MarcoChef.class, name = "Marco")
//    })


    public interface Chef {
        String getName();
        String getFood();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class AntonioChef implements Chef {
        private String type;
        private String name;
        private String food;
        private String specAntonio;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class MarcoChef implements Chef {
        private String type;

        private String name;
        private String food;

        private String specMarco;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class TreenetChef implements Chef {
        private String type;

        private String name;
        private String food;

        private String specMarco;
        private String specTree;
    }
}
