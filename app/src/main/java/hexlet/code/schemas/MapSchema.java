package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema{
    private boolean requiredRule;
    private boolean sizeofRule;
    private int size;
    @Override
    public boolean isValid(Object data) {
        boolean result = true;
        Map<?, ?> map = (Map<?, ?>) data;
        if (requiredRule && data == null) {
            result = false;
        } else if (sizeofRule && map.size() != this.size) {
            result = false;
        }
        return result;
    }
    public MapSchema required() {
        this.requiredRule = true;
        return this;
    }
    public MapSchema sizeof(int size) {
        this.sizeofRule = true;
        this.size = size;
        return this;
    }
}
