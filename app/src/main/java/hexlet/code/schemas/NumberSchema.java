package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean requiredRule = false;
    private boolean positiveRule = false;
    private boolean rangeRule = false;
    private int min;
    private int max;
    @Override
    public boolean isValid(Object data) {
        boolean result = true;
        if (!requiredRule && data == null) {
            return true;
        } else if (requiredRule && data == null) {
            result = false;
        } else if (positiveRule && (int) data < 0) {
            result = false;
        } else if (rangeRule && ((int) data < min || (int) data > max)) {
            result = false;
        }
        return result;
    }
    public NumberSchema required() {
        this.requiredRule = true;
        return this;
    }
    public NumberSchema positive() {
        this.positiveRule = true;
        return this;
    }
    public NumberSchema range(int a1, int a2) {
        this.rangeRule = true;
        this.min = a1;
        this.max = a2;
        return this;
    }
}
