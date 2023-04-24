package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSchema extends BaseSchema {
    private boolean requiredRule;
    private boolean sizeofRule;
    private int size;
    private Map<String, BaseSchema> mapRules = new HashMap<>();
    @Override
    public boolean isValid(Object data) {
        boolean result = true;
        Map<String, Object> map = (Map<String, Object>) data;
        if (requiredRule && data == null) {
            result = false;
        } else if (sizeofRule && map.size() != this.size) {
            result = false;
        } else if (!mapRules.isEmpty()) {
            Set<String> keys = map.keySet();
            for (String key: keys) {
                if (!mapRules.get(key).isValid(map.get(key))) {
                    result = false;
                }
            }
        }
        return result;
    }
    public MapSchema required() {
        this.requiredRule = true;
        return this;
    }
    public MapSchema sizeof(int sizeRule) {
        this.sizeofRule = true;
        this.size = sizeRule;
        return this;
    }
    public void shape(Map<String, BaseSchema> rulesMap) {
        this.mapRules = rulesMap;
    }
}
