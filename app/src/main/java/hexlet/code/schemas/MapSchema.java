package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;


public class MapSchema extends BaseSchema {
    private boolean isRequired;
    private boolean isSizeOf;
    private boolean isValueValid;
    private int size;
    private Map<String, BaseSchema> mapWithRules = new HashMap<>();
    @Override
    public final boolean isValid(Object data) {
        boolean result = true;
        Map<String, Object> map = (Map<String, Object>) data;
        if (isRequired) {
            result = (data != null);
        }
        if (isSizeOf) {
            result = (map.size() == this.size);
        }
        if (isValueValid) {
            for (String key: map.keySet()) {
                if (!mapWithRules.get(key).isValid(map.get(key))) {
                    result = false;
                }
            }
        }
        return result;
    }
    public final MapSchema required() {
        this.isRequired = true;
        return this;
    }
    public final MapSchema sizeof(int sizeRule) {
        this.isSizeOf = true;
        this.size = sizeRule;
        return this;
    }
    public final void shape(Map<String, BaseSchema> rulesMap) {
        this.isValueValid = true;
        this.mapWithRules = rulesMap;
    }
}
