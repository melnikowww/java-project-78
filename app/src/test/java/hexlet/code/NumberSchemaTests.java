package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTests {
    public Validator validator;
    public NumberSchema schema;
    @BeforeEach
    public void makeSchema() {
        this.validator = new Validator();
        this.schema = validator.number();
    }
    @Test
    public void withoutRules() {
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.positive().isValid(null)).isTrue();
    }
    @Test
    public void withRules() {
        assertThat(schema.required().isValid(null)).isFalse();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.positive().isValid(-10)).isFalse();
        assertThat(schema.range(5, 10).isValid(7)).isTrue();
        assertThat(schema.range(0, 10).isValid(11)).isFalse();
        assertThat(schema.isValid(-2)).isFalse();
    }
}
