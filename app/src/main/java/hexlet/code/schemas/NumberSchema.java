package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean isRequired = false;
    private boolean isPositive = false;
    private boolean isInRange = false;
    private int min;
    private int max;
    @Override
    public boolean isValid(Object data) {
        boolean result = true;
        if (!isRequired && data == null) {
            return true;
        } else if (isRequired && data == null) {
            return false;
        }
        int intData = (int) data;
        if (isPositive) {
            result = (intData > 0);
        }
        if (isInRange) {
            result = (intData > min & intData < max);
        }
        return result;
    }
    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }
    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }
    public NumberSchema range(int a1, int a2) {
        this.isInRange = true;
        this.min = a1;
        this.max = a2;
        return this;
    }
}
