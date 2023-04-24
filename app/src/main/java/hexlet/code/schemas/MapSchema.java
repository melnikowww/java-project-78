package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSchema extends BaseSchema {
    private boolean isRequired;
    private boolean isSizeOf;
    private int size;
    private Map<String, BaseSchema> mapWithRules = new HashMap<>();
    @Override
    public boolean isValid(Object data) {
        boolean result = true;
        Map<String, Object> map = (Map<String, Object>) data;
        if (isRequired) {
            result = (data != null);
        }
        if (isSizeOf) {
            result = (map.size() == this.size);
        }
        if (!mapWithRules.isEmpty()) {
            Set<String> keys = map.keySet();
            for (String key: keys) {
                if (!mapWithRules.get(key).isValid(map.get(key))) {
                    result = false;
                }
            }
        }
        return result;
    }
    public MapSchema required() {
        this.isRequired = true;
        return this;
    }
    public MapSchema sizeof(int sizeRule) {
        this.isSizeOf = true;
        this.size = sizeRule;
        return this;
    }
    public void shape(Map<String, BaseSchema> rulesMap) {
        this.mapWithRules = rulesMap;
    }
}
