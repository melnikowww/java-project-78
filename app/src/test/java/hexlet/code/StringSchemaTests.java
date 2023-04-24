package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTests {
    public Validator validator;
    public StringSchema schema;
    @BeforeEach
    public void makeSchema() {
        validator = new Validator();
        schema = validator.string();
    }
    @Test
    public void stringSchemaTest() {
        assertThat(schema.isValid("")).isEqualTo(true);
        assertThat(schema.isValid(null)).isEqualTo(true);
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        makeSchema();
        assertThat(schema.contains("wh").isValid("what does the fox say"))
            .isEqualTo(true);
        assertThat(schema.contains("whattt").isValid("what does the fox say"))
            .isEqualTo(false);
        makeSchema();
        assertThat(schema.minLength(1).isValid("what does the fox say"))
            .isEqualTo(true);
        assertThat(schema.minLength(100).isValid("what does the fox say"))
            .isEqualTo(false);

    }
}
