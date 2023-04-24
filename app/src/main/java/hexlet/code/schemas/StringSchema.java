package hexlet.code.schemas;


public class StringSchema extends BaseSchema {
    private boolean isRequired = false;
    private boolean isMinLength = false;
    private int minLength = -1;
    private boolean isContained = false;
    private String containsString;
    @Override
    public boolean isValid(Object data) {
        String stringData = (String) data;
        boolean result = true;
        if (isRequired) {
            result = !(data == null || data.equals(""));
        }
        if (isMinLength) {
            result = (stringData.length() >= minLength);
        }
        if (isContained) {
            result = (stringData.contains(containsString));
        }
        return result;
    }
    public StringSchema required() {
        this.isRequired = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.isMinLength = true;
        this.minLength = length;
        return this;
    }
    public StringSchema contains(String data) {
        this.isContained = true;
        this.containsString = data;
        return this;
    }
}
