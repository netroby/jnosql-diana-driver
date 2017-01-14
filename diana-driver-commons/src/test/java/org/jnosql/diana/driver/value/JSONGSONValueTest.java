package org.jnosql.diana.driver.value;

import org.jnosql.diana.api.TypeReference;
import org.jnosql.diana.api.Value;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class JSONGSONValueTest {

    @Test(expected = NullPointerException.class)
    public void shouldReturnErrorWhenElementIsNull() {
        JSONGSONValue.of(null);
    }


    @Test
    public void shouldConvertType() {
        AtomicInteger number = new AtomicInteger(5_000);
        Value value = JSONGSONValue.of(number);
        assertEquals(Integer.valueOf(5_000), value.get(Integer.class));
        assertEquals("5000", value.get(String.class));
    }


    @Test
    public void shouldConvertMapIgnoringKeyValue() {
        Map<Integer, List<String>> map = Collections.singletonMap(10, Arrays.asList("1", "2", "3"));
        Value value = JSONGSONValue.of(map);
        Map<String, List<String>> result = value.get(new TypeReference<Map<String, List<String>>>(){});
        List<String> valueResult = result.get("10");
        assertThat(result.keySet(), containsInAnyOrder("10"));
        assertThat(valueResult, containsInAnyOrder("1", "2", "3"));
    }
}