package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate predicate) {
        checks.put(name, predicate);
    }
    public boolean isValid(Object data) {
        for (Predicate predicate : checks.values()) {
            if (!predicate.test(data)) {
                return false;
            }
        }
        return true;
    }
}

