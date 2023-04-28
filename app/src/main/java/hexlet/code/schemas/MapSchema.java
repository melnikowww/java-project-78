package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        addCheck("required",
            value -> value instanceof Map);
        return this;
    }
    public final MapSchema sizeof(int sizeRule) {
        addCheck("sizeof",
            value -> ((Map<String, Object>) value).size() == sizeRule);
        return this;
    }
    public final void shape(Map<String, BaseSchema> rulesMap) {
        addCheck("shape",
            value -> {
                boolean result = true;
                for (String key: ((Map<String, Object>) value).keySet()) {
                    if (!rulesMap.get(key).isValid(((Map<String, Object>) value).get(key))) {
                        result = false;
                    }
                }
                return result;
            });
    }
}
