package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean requiredRule = false;
    private boolean positiveRule = false;
    private boolean rangeRule = false;
    private int min;
    private int max;
    @Override
    public boolean isValid(Object data) {
        if (!requiredRule && data == null) {
            return true;
        } else if (((positiveRule && (int) data < 0))
            || (requiredRule && data == null)
            || (rangeRule && ((int) data < min || (int) data > max))) {
            return false;
        } else {
            return true;
        }
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
