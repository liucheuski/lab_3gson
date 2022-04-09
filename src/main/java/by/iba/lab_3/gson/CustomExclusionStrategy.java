package by.iba.lab_3.gson;

import by.iba.lab_3.annatation.ExcludeField;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomExclusionStrategy implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if ("salary".equals(fieldAttributes.getName())) {
            return true;
        }
        if (fieldAttributes.getAnnotation(ExcludeField.class) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return (aClass == typeToSkip);
    }
}
