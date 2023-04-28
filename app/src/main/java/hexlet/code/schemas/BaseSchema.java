package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate predicate) {
        checks.put(name, predicate);
    }
    /**
     * Base validation.
     * @param data is data which needs to be validated
     * @return boolean result
     */
    protected boolean isValid(Object data) {
        for (Predicate predicate : checks.values()) {
            if (checks.containsKey("required")
                && !checks.get("required").test(data)) {
                return false;
            }
            try {
                if (!predicate.test(data)) {
                    return false;
                }
            } catch (NullPointerException exception) {
                return true;
            }
        }
        return true;
    }
}
