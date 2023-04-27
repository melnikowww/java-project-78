package hexlet.code.schemas;


import java.util.Objects;

public class NumberSchema extends BaseSchema {
    @Override
    public boolean isValid(Object data) {
        try {
            return super.isValid(data);
        } catch (NullPointerException exception) {
            return true;
        } catch (ClassCastException exception) {
            return false;
        }
    }
    public final NumberSchema required() {
        addCheck("required",
            Objects::nonNull);
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
