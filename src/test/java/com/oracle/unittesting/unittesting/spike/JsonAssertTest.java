package com.oracle.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_strictTrue() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_strictFalse() throws JSONException {

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    public void jsonAssert_withoutEscapeCharacter() throws JSONException {

        String expectedResponse = "{id:1, name:Ball,price:10}"; // you should only use the escape char when we have spaces between values
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
