package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BotAutTest extends Assert {

    @Test
    public void testGetToken() throws IOException {

    }

    @Test
    public void testGetAuthData() throws IOException {
        AuthData ad = AuthUtils.getAuthData();
        assertNotNull(ad);
        assertNotNull(ad.CLIENT_ID);
        assertNotNull(ad.CLIENT_SECRET);
    }

}
