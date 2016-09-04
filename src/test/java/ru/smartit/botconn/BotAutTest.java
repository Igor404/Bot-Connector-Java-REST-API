package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BotAutTest extends Assert {

    @Test
    public void testGetToken() throws IOException, OAuthEx {
        try {
            BotAuth.reqToken("", "");
            fail("Must throw an 'invalid_request' OAuthEx");
        } catch (final OAuthEx ex) {
            assertEquals("invalid_request", ex.type);
        }
        try {
            BotAuth.reqToken("invalid key", "invalid pass");
            fail("Must throw an 'unauthorized_client' OAuthEx");
        } catch (final OAuthEx ex) {
            assertEquals("unauthorized_client", ex.type);
        }
    }

    @Test
    public void testGetAuthData() throws IOException {
        AuthData ad = AuthUtils.getAuthData();
        assertNotNull(ad);
        assertNotNull(ad.CLIENT_ID);
        assertNotNull(ad.CLIENT_SECRET);
    }

}
