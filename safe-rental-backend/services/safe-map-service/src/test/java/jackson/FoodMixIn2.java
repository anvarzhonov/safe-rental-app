package jackson;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME, property = "student")
@JsonTypeName(value = "typee")
// @JsonRootName(value = "fs")
public abstract class FoodMixIn2 {
}
