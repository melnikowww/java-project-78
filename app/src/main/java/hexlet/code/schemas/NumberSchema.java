package hexlet.code.schemas;


public class NumberSchema extends BaseSchema {
    @Override
    public boolean isValid(Object data) {
        if (data instanceof Integer || data == null) {
            try {
                return super.isValid(data);
            } catch (NullPointerException exception) {
                System.out.println("NPE: " + data);
                return true;
            } catch (ClassCastException exception) {
//                System.out.println("ClassCastException");
                return false;
            }
        } else {
            return false;
        }
    }
    public final NumberSchema required() {
        addCheck("required",
            value -> value != null);
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
