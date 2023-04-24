package hexlet.code.schemas;


public class StringSchema extends BaseSchema {
    private boolean requiredRule = false;
    private boolean minLengthRule = false;
    private int minLength = -1;
    private boolean containsRule = false;
    private String containsString;
    @Override
    public boolean isValid(Object data) {
        String stringData = (String) data;
        return (!requiredRule || (data != null && !data.equals("")))
            && (!minLengthRule || stringData.length() >= minLength)
            && (!containsRule || stringData.contains(containsString));
    }
    public StringSchema required() {
        this.requiredRule = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.minLengthRule = true;
        this.minLength = length;
        return this;
    }
    public StringSchema contains(String data) {
        this.containsRule = true;
        this.containsString = data;
        return this;
    }
}
