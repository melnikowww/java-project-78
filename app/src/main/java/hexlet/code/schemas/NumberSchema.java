package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        addCheck("required",
            value -> value instanceof Integer);
        return this;
    }
    public final NumberSchema positive() {
        addCheck("positive",
            value -> (int) value > 0);
        return this;
    }
    public final NumberSchema range(int a1, int a2) {
        addCheck("range",
            value -> (int) value >= a1 && (int) value <= a2);
        return this;
    }
}
