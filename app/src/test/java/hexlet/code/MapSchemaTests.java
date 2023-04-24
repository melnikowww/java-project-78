package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTests {
    private Validator validator;
    private MapSchema schema;
    @BeforeEach
    public void makeSchema() {
        this.validator = new Validator();
        this.schema = validator.map();
    }
    @Test
    public void withoutRules() {
        assertThat(schema.isValid(null)).isTrue();
    }
    @Test
    public void withRules() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isTrue();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
        schema.sizeof(2);
        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
    }
}
