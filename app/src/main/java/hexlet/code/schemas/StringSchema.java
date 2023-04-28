package hexlet.code.schemas;


public class StringSchema extends BaseSchema {
    public final boolean isValid(Object data) {
        return super.isValid(data);
    }
    public final StringSchema required() {
        addCheck("required",
            value -> !(value == null || value.equals("")));
        return this;
    }
    public final StringSchema minLength(int minLength) {

        addCheck("minLength",
            value -> (((String) value).length() >= minLength));
        return this;
    }
    public final StringSchema contains(String data) {
        addCheck("minLength",
            value -> (((String) value).contains(data)));
        return this;
    }
}
