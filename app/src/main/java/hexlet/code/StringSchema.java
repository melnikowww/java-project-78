package hexlet.code;

public class StringSchema implements Schema {
    private boolean requiredRule = false;
    private boolean minLengthRule = false;
    private int minLength = -1;
    private boolean containsRule = false;
    private String containsString;
    public boolean isValid(String data) {
        boolean result = true;
        if (requiredRule && (data == null || data.equals(""))) {
            result = false;
        } else if (minLengthRule && data.length() < minLength) {
            result = false;
        } else if (containsRule && !data.contains(containsString)) {
            result = false;
        }
        return result;
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
