package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class AuthUtils {
    public static AuthData getAuthData() {
        final AuthData res;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("auth.json");
            ObjectMapper mapper = new ObjectMapper();
            res = mapper.readValue(is, AuthData.class);
        } catch (final Exception ex) {
            throw new Error(ex);
        }
        return res;
    }
}
