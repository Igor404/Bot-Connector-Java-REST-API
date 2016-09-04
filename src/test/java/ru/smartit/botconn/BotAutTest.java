package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import ru.smartit.botconn.model.AuthData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class BotAutTest extends Assert {

    @Test
    public void testGetToken() throws IOException {

    }

    @Test
    public void testGetAuthData() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("auth.properties");
        ObjectMapper mapper = new ObjectMapper();
        AuthData jsonMap = mapper.readValue(is, AuthData.class);
        assertNotNull(jsonMap.CLIENT_ID);
        assertNotNull(jsonMap.CLIENT_SECRET);
    }

}
