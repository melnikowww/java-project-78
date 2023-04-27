package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate predicate) {
        checks.put(name, predicate);
    }
    protected boolean isValid(Object data) {
        for (Predicate predicate : checks.values()) {
            if (checks.containsKey("required")
                && !checks.get("required").test(data)) {
                return false;
            }
            if (!predicate.test(data)) {
                return false;
            }
        }
        return true;
    }
}
